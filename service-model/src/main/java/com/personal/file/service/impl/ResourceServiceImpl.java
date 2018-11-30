package com.personal.file.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.personal.config.FileConfig;
import com.personal.file.dao.ResourceDao;
import com.personal.file.domain.ResourceDO;
import com.personal.file.handler.FileTask;
import com.personal.file.service.ResourceService;
import com.personal.file.vo.ImageVo;
import com.personal.utils.FileUtil;



@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private FileConfig fileConfig;
	
	@Override
	public ResourceDO get(Integer id){
		return resourceDao.get(id);
	}
	
	@Override
	public List<ResourceDO> list(Map<String, Object> map){
		return resourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return resourceDao.count(map);
	}
	
	@Override
	public int save(ResourceDO resource){
		return resourceDao.save(resource);
	}
	
	@Override
	public int update(ResourceDO resource){
		return resourceDao.update(resource);
	}
	
	@Override
	public int remove(Integer id){
		return resourceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return resourceDao.batchRemove(ids);
	}
	
	@Override
	public ResourceDO uploadAndSave(MultipartFile file) throws Exception{
		
		ResourceDO resourceDO = null;
		ImageVo imageVo = upload(file);
		
		if(imageVo != null){
			
			resourceDO = ResourceDO.builder()
					.addTime(new Date())
					.big(imageVo.getBig())
					.middle(imageVo.getMiddle())
					.thumb(imageVo.getThumb())
					.suffix(imageVo.getSuffix())
					.type(FileUtil.fileType(imageVo.getSuffix()))
					.origin(imageVo.getOrigin())
					.name(imageVo.getFileName())
					.build();
			int ret = resourceDao.insertUseGeneratedKeys(resourceDO);
		}
		
		return resourceDO;
	}

	/**
	 * 多线程上传图片
	 * @param file
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public ImageVo upload(MultipartFile file) throws InterruptedException, ExecutionException {
		
		
		ImageVo imageVo = null;
		
		String [] fileStr = uploadOrigin(file);
		
		FileTask big = new FileTask(fileStr[0], fileConfig.getUploadPath() + fileConfig.getBig() + fileStr[1]+"_big", 1024, 1024);
		
		FileTask middle = new FileTask(fileStr[0], fileConfig.getUploadPath() + fileConfig.getMiddle() + fileStr[1]+"_middle", 512, 512);
		
		FileTask thumb = new FileTask(fileStr[0], fileConfig.getUploadPath() + fileConfig.getThumb() + fileStr[1]+"_thumb", 128, 128);
		
		FutureTask<String> bigTask = new FutureTask<String>(big);
		FutureTask<String> middleTask = new FutureTask<String>(middle);
		FutureTask<String> thumbTask = new FutureTask<String>(thumb);
		
		Thread bigThread = new Thread(bigTask);
		Thread middleThread = new Thread(middleTask);
		Thread thumbThread = new Thread(thumbTask);
		
		bigThread.start();
		middleThread.start();
		thumbThread.start();
		
		if(bigTask.isDone() && middleTask.isDone() && thumbTask.isDone()){
			imageVo = ImageVo.builder()
					.origin(fileStr[0])
					.big(bigTask.get())
					.middle(middleTask.get())
					.thumb(thumbTask.get())
					.suffix(fileStr[2])
					.build();
		}
		
		return imageVo;
	}
	
	
	private String[] uploadOrigin(MultipartFile file){
		
		String [] fileStr = new String[3];
		
		String path = fileConfig.getUploadPath() + fileConfig.getOrigin();
		
		String filesuffix = FileUtil.filesuffix(file.getName());
		
		String fileName = FileUtil.renameToUUID(file.getName());
		
		try {
			FileUtil.uploadFile(file.getBytes(), path, fileName);
			
			fileStr[0] = path;
			fileStr[1] = fileName;
			fileStr[2] = filesuffix;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileStr;
	}
	
	 
}
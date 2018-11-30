package com.personal.file.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.personal.common.utils.PageUtils;
import com.personal.common.utils.Query;
import com.personal.common.utils.R;
import com.personal.file.domain.ResourceDO;
import com.personal.file.service.ResourceService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-30 16:00:12
 */
 
@Controller
@RequestMapping("/file/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@GetMapping()
	@RequiresPermissions("file:resource:resource")
	String Resource(){
	    return "file/resource/resource";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("file:resource:resource")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ResourceDO> resourceList = resourceService.list(query);
		int total = resourceService.count(query);
		PageUtils pageUtils = new PageUtils(resourceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("file:resource:add")
	String add(){
	    return "file/resource/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("file:resource:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ResourceDO resource = resourceService.get(id);
		model.addAttribute("resource", resource);
	    return "file/resource/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("file:resource:add")
	public R save( ResourceDO resource){
		if(resourceService.save(resource)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("file:resource:edit")
	public R update( ResourceDO resource){
		resourceService.update(resource);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("file:resource:remove")
	public R remove( Integer id){
		if(resourceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("file:resource:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		resourceService.batchRemove(ids);
		return R.ok();
	}
	
	
	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		 
		ResourceDO resourceDO = null;
		try {
			resourceDO = resourceService.uploadAndSave(file);
			
			if (resourceDO != null) {
				return R.ok().put("resource",resourceDO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return R.error();
	}
	
}

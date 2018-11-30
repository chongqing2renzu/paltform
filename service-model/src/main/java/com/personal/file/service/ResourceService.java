package com.personal.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.personal.file.domain.ResourceDO;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-30 16:00:12
 */
public interface ResourceService {
	
	ResourceDO get(Integer id);
	
	List<ResourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ResourceDO resource);
	
	int update(ResourceDO resource);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
    ResourceDO uploadAndSave(MultipartFile file) throws Exception;
	
}

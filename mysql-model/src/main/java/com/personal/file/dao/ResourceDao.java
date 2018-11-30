package com.personal.file.dao;

import com.personal.common.MyBaseMapper;
import com.personal.file.domain.ResourceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-30 16:00:12
 */
@Mapper
public interface ResourceDao extends MyBaseMapper<ResourceDO>{

	ResourceDO get(Integer id);
	
	List<ResourceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ResourceDO resource);
	
	int update(ResourceDO resource);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

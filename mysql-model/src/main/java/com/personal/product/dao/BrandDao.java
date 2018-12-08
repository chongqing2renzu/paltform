package com.personal.product.dao;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.BrandDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:21:42
 */
@Mapper
public interface BrandDao extends MyBaseMapper<BrandDO>{

	BrandDO get(Integer id);
	
	List<BrandDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(BrandDO brand);
	
	int update(BrandDO brand);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

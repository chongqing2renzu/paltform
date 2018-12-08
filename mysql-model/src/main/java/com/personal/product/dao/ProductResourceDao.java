package com.personal.product.dao;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.ProductResourceDO;

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
public interface ProductResourceDao extends MyBaseMapper<ProductResourceDO>{

	ProductResourceDO get(Integer id);
	
	List<ProductResourceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductResourceDO productResource);
	
	int update(ProductResourceDO productResource);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

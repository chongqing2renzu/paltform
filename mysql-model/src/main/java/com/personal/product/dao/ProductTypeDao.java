package com.personal.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.ProductTypeDO;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-27 17:27:26
 */
//@Mapper
public interface ProductTypeDao extends MyBaseMapper<ProductTypeDO>{

	ProductTypeDO get(Integer id);
	
	List<ProductTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductTypeDO productType);
	
	int update(ProductTypeDO productType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

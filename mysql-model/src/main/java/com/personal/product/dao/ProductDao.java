package com.personal.product.dao;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.ProductDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-29 22:01:07
 */
@Mapper
public interface ProductDao extends MyBaseMapper<ProductDO>{

	ProductDO get(Integer id);
	
	List<ProductDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

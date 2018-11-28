package com.personal.product.dao;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.ProductDimensionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
@Mapper
public interface ProductDimensionDao extends MyBaseMapper<ProductDimensionDO>{

	ProductDimensionDO get(Integer id);
	
	List<ProductDimensionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductDimensionDO productDimension);
	
	int update(ProductDimensionDO productDimension);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

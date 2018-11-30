package com.personal.product.service;

import com.personal.product.domain.ProductDimensionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
public interface ProductDimensionService {
	
	ProductDimensionDO get(Integer id);
	
	List<ProductDimensionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDimensionDO productDimension);
	
	int update(ProductDimensionDO productDimension);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

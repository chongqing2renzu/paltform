package com.personal.product.service;

import com.personal.product.domain.ProductResourceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:21:42
 */
public interface ProductResourceService {
	
	ProductResourceDO get(Integer id);
	
	List<ProductResourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductResourceDO productResource);
	
	int update(ProductResourceDO productResource);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

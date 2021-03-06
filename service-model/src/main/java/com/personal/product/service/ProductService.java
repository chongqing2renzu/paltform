package com.personal.product.service;

import java.util.List;
import java.util.Map;

import com.personal.product.domain.ProductDO;
import com.personal.product.dto.AddProductDto;
import com.personal.product.dto.QueryProductDto;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-29 22:01:07
 */
public interface ProductService {
	
	ProductDO get(Integer id);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	int add(AddProductDto addProductDto);
	
	List<ProductDO> list(QueryProductDto queryProductDto);
}

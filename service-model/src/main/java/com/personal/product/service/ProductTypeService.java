package com.personal.product.service;

import java.util.List;
import java.util.Map;

import com.personal.product.domain.ProductTypeDO;
import com.personal.product.vo.ProductTypeVo;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-27 17:27:26
 */
public interface ProductTypeService {
	
	ProductTypeDO get(Integer id);
	
	List<ProductTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductTypeDO productType);
	
	int update(ProductTypeDO productType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	List<ProductTypeVo> productTypeList(Integer typeId);
}

package com.personal.product.service;

import com.personal.product.domain.ProductPromotionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
public interface ProductPromotionService {
	
	ProductPromotionDO get(Integer id);
	
	List<ProductPromotionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductPromotionDO productPromotion);
	
	int update(ProductPromotionDO productPromotion);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

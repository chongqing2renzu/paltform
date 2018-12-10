package com.personal.product.service;

import com.personal.product.domain.PromotionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-10 16:23:48
 */
public interface PromotionService {
	
	PromotionDO get(Integer id);
	
	List<PromotionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PromotionDO promotion);
	
	int update(PromotionDO promotion);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

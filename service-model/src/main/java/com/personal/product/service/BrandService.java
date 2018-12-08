package com.personal.product.service;

import com.personal.product.domain.BrandDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:21:42
 */
public interface BrandService {
	
	BrandDO get(Integer id);
	
	List<BrandDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BrandDO brand);
	
	int update(BrandDO brand);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	List<BrandDO> list(BrandDO brandDO);
}

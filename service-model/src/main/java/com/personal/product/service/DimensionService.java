package com.personal.product.service;

import java.util.List;
import java.util.Map;

import com.personal.product.domain.DimensionDO;
import com.personal.product.vo.ProductTypeVo;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-02 15:56:54
 */
public interface DimensionService {
	
	DimensionDO get(Integer id);
	
	List<DimensionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DimensionDO dimension);
	
	int update(DimensionDO dimension);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
}

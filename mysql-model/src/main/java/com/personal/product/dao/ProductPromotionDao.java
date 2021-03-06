package com.personal.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.personal.common.MyBaseMapper;
import com.personal.product.domain.ProductPromotionDO;

/**
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
@Mapper
public interface ProductPromotionDao extends MyBaseMapper<ProductPromotionDO>{

	ProductPromotionDO get(Integer id);
	
	List<ProductPromotionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductPromotionDO productPromotion);
	
	int update(ProductPromotionDO productPromotion);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

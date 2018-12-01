package com.personal.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.product.dao.ProductPromotionDao;
import com.personal.product.domain.ProductPromotionDO;
import com.personal.product.service.ProductPromotionService;



@Service
public class ProductPromotionServiceImpl implements ProductPromotionService {
	@Autowired
	private ProductPromotionDao productPromotionDao;
	
	@Override
	public ProductPromotionDO get(Integer id){
		return productPromotionDao.get(id);
	}
	
	@Override
	public List<ProductPromotionDO> list(Map<String, Object> map){
		return productPromotionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productPromotionDao.count(map);
	}
	
	@Override
	public int save(ProductPromotionDO productPromotion){
		return productPromotionDao.save(productPromotion);
	}
	
	@Override
	public int update(ProductPromotionDO productPromotion){
		return productPromotionDao.update(productPromotion);
	}
	
	@Override
	public int remove(Integer id){
		return productPromotionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return productPromotionDao.batchRemove(ids);
	}
	
}

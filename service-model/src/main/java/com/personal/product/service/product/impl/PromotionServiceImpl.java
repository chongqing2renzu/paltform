package com.personal.product.service.product.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.product.dao.PromotionDao;
import com.personal.product.domain.PromotionDO;
import com.personal.product.service.PromotionService;



@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	private PromotionDao promotionDao;
	
	@Override
	public PromotionDO get(Integer id){
		return promotionDao.get(id);
	}
	
	@Override
	public List<PromotionDO> list(Map<String, Object> map){
		return promotionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return promotionDao.count(map);
	}
	
	@Override
	public int save(PromotionDO promotion){
		return promotionDao.save(promotion);
	}
	
	@Override
	public int update(PromotionDO promotion){
		return promotionDao.update(promotion);
	}
	
	@Override
	public int remove(Integer id){
		return promotionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return promotionDao.batchRemove(ids);
	}
	
}

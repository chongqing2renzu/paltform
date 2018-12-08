package com.personal.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.personal.product.dao.BrandDao;
import com.personal.product.domain.BrandDO;
import com.personal.product.service.BrandService;



@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	
	@Override
	public BrandDO get(Integer id){
		return brandDao.get(id);
	}
	
	@Override
	public List<BrandDO> list(Map<String, Object> map){
		return brandDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return brandDao.count(map);
	}
	
	@Override
	public int save(BrandDO brand){
		return brandDao.save(brand);
	}
	
	@Override
	public int update(BrandDO brand){
		return brandDao.update(brand);
	}
	
	@Override
	public int remove(Integer id){
		return brandDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return brandDao.batchRemove(ids);
	}

	@Override
	public List<BrandDO> list(BrandDO brandDO) {
		// TODO Auto-generated method stub
		return brandDao.select(brandDO);
	}
	
}

package com.personal.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.personal.product.dao.ProductResourceDao;
import com.personal.product.domain.ProductResourceDO;
import com.personal.product.service.ProductResourceService;



@Service
public class ProductResourceServiceImpl implements ProductResourceService {
	@Autowired
	private ProductResourceDao productResourceDao;
	
	@Override
	public ProductResourceDO get(Integer id){
		return productResourceDao.get(id);
	}
	
	@Override
	public List<ProductResourceDO> list(Map<String, Object> map){
		return productResourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productResourceDao.count(map);
	}
	
	@Override
	public int save(ProductResourceDO productResource){
		return productResourceDao.save(productResource);
	}
	
	@Override
	public int update(ProductResourceDO productResource){
		return productResourceDao.update(productResource);
	}
	
	@Override
	public int remove(Integer id){
		return productResourceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return productResourceDao.batchRemove(ids);
	}
	
}

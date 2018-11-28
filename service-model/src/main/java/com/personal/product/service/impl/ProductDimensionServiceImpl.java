package com.personal.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.personal.product.dao.ProductDimensionDao;
import com.personal.product.domain.ProductDimensionDO;
import com.personal.product.service.ProductDimensionService;



@Service
public class ProductDimensionServiceImpl implements ProductDimensionService {
	@Autowired
	private ProductDimensionDao productDimensionDao;
	
	@Override
	public ProductDimensionDO get(Integer id){
		return productDimensionDao.get(id);
	}
	
	@Override
	public List<ProductDimensionDO> list(Map<String, Object> map){
		return productDimensionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDimensionDao.count(map);
	}
	
	@Override
	public int save(ProductDimensionDO productDimension){
		return productDimensionDao.save(productDimension);
	}
	
	@Override
	public int update(ProductDimensionDO productDimension){
		return productDimensionDao.update(productDimension);
	}
	
	@Override
	public int remove(Integer id){
		return productDimensionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return productDimensionDao.batchRemove(ids);
	}
	
}

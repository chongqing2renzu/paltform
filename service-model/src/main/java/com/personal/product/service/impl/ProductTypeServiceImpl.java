package com.personal.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.product.dao.ProductTypeDao;
import com.personal.product.domain.ProductTypeDO;
import com.personal.product.service.ProductTypeService;
import com.personal.utils.PinYinUtil;



@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeDao productTypeDao;
	
	@Override
	public ProductTypeDO get(Integer id){
		return productTypeDao.get(id);
	}
	
	@Override
	public List<ProductTypeDO> list(Map<String, Object> map){
		return productTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productTypeDao.count(map);
	}
	
	@Override
	public int save(ProductTypeDO productType){
		productType.setFullPy(PinYinUtil.ToPinyin(productType.getName()));
		productType.setShortPy(PinYinUtil.ToFirstChar(productType.getName()));
		return productTypeDao.save(productType);
	}
	
	@Override
	public int update(ProductTypeDO productType){
		return productTypeDao.update(productType);
	}
	
	@Override
	public int remove(Integer id){
		return productTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return productTypeDao.batchRemove(ids);
	}
	
}

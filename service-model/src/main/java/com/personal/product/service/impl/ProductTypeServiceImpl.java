package com.personal.product.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.product.dao.ProductTypeDao;
import com.personal.product.domain.ProductTypeDO;
import com.personal.product.service.ProductTypeService;
import com.personal.product.vo.ProductTypeVo;
import com.personal.utils.PinYinUtil;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;



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

	@Override
	public List<ProductTypeVo> productTypeList(Integer typeId) {
		
		List<ProductTypeVo> list = new ArrayList<ProductTypeVo>();
		
		while (true){
			ProductTypeVo productTypeVo = productType(typeId);
			list.add(productTypeVo);
			
			typeId = productTypeVo.getPid();
			if(typeId == 0){
				break;
			}
		}
		
		Collections.reverse(list);
		return list;
	}
	
	public ProductTypeVo productType(Integer typeId){
		ProductTypeDO productTypeDO = productTypeDao.get(typeId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid", productTypeDO.getPid());
		
		return ProductTypeVo.builder().list(productTypeDao.list(map)).typeId(typeId).pid(productTypeDO.getPid()).build();
	}

	@Override
	public List<ProductTypeDO> productTypeList(ProductTypeDO productTypeDO) {
		return productTypeDao.select(productTypeDO);
	}
	
	@Override
	public List<ProductTypeDO> productTypeListLike(ProductTypeDO productTypeDO) {
		
		Condition condition = new Condition(ProductTypeDO.class);
		Criteria criteria = condition.createCriteria();
		if(StringUtils.isNoneBlank(productTypeDO.getFullPy())){
			criteria.andLike("fullPy", productTypeDO.getFullPy());
		}
		
		if(StringUtils.isNoneBlank(productTypeDO.getShortPy())){
			criteria.andLike("shortPy", productTypeDO.getShortPy());
		}
		
		if(StringUtils.isNoneBlank(productTypeDO.getName())){
			criteria.andLike("name", productTypeDO.getName());
		}
		
		if(productTypeDO.getPid() != null){
			criteria.andEqualTo("pid", productTypeDO.getPic());
		}
		
		return productTypeDao.selectByCondition(condition);
	}
	
}

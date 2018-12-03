package com.personal.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.product.dao.DimensionDao;
import com.personal.product.domain.DimensionDO;
import com.personal.product.service.DimensionService;
import com.personal.product.vo.ProductTypeVo;



@Service
public class DimensionServiceImpl implements DimensionService {
	@Autowired
	private DimensionDao dimensionDao;
	
	@Override
	public DimensionDO get(Integer id){
		return dimensionDao.get(id);
	}
	
	@Override
	public List<DimensionDO> list(Map<String, Object> map){
		return dimensionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dimensionDao.count(map);
	}
	
	@Override
	public int save(DimensionDO dimension){
		if(dimension.getTypeId() == null) {
			dimension.setTypePid(dimension.getTypePid());
		}
		return dimensionDao.save(dimension);
	}
	
	@Override
	public int update(DimensionDO dimension){
		return dimensionDao.update(dimension);
	}
	
	@Override
	public int remove(Integer id){
		return dimensionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return dimensionDao.batchRemove(ids);
	}

	
}

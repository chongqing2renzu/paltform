package com.personal.product.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.file.dao.ResourceDao;
import com.personal.file.domain.ResourceDO;
import com.personal.product.dao.ProductDao;
import com.personal.product.dao.ProductDimensionDao;
import com.personal.product.dao.ProductResourceDao;
import com.personal.product.domain.ProductDO;
import com.personal.product.domain.ProductDimensionDO;
import com.personal.product.domain.ProductResourceDO;
import com.personal.product.dto.AddProductDto;
import com.personal.product.dto.AddProductDto.Product;
import com.personal.product.service.ProductService;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private ProductResourceDao productResourceDao;
	
	@Autowired
	private ProductDimensionDao productDimensionDao;
	
	@Override
	public ProductDO get(Integer id){
		return productDao.get(id);
	}
	
	@Override
	public List<ProductDO> list(Map<String, Object> map){
		return productDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDao.count(map);
	}
	
	@Override
	public int save(ProductDO product){
		return productDao.save(product);
	}
	
	@Override
	public int update(ProductDO product){
		return productDao.update(product);
	}
	
	@Override
	public int remove(Integer id){
		return productDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return productDao.batchRemove(ids);
	}

	@Override
	@Transactional
	public int add(AddProductDto v) {
		
		//查询图片
		Condition condition = new Condition(ResourceDO.class);
		Criteria criteria = condition.createCriteria();
		criteria.andIn("id", v.getImgId());
		
		condition.orderBy("id").asc();
		
		
		List<ResourceDO> list = resourceDao.selectByCondition(condition);
		
		BigDecimal minMoney = null;
		BigDecimal maxMoney = null;
		
		BigDecimal realMinMoney = null;
		BigDecimal realMaxMoney = null;
		
		for(Product p : v.getProducts()){
			if(minMoney == null 
			   ||maxMoney == null
			   ||realMinMoney == null 
			   ||realMaxMoney == null){
				minMoney = p.getMoney();
				maxMoney = p.getMoney();
				realMinMoney = p.getRealMoney();
				realMaxMoney = p.getRealMoney();
			} else {
				if(minMoney.compareTo(p.getMoney()) > 0){
					minMoney = p.getMoney();
				}
				
				if(maxMoney.compareTo(p.getMoney()) < 0){
					maxMoney = p.getMoney();
				}
				
				if(realMinMoney.compareTo(p.getRealMoney()) > 0){
					realMinMoney = p.getRealMoney();
				}
				
				if(realMaxMoney.compareTo(p.getRealMoney()) < 0){
					realMaxMoney = p.getRealMoney();
				}
				
			}
		}
		
		//新增商品
		ProductDO productDO = ProductDO.builder()
			.addTime(new Date())
			.brandId(v.getBrandId())
			.brandName(v.getBrandName())
			.dimensionData(v.getDimensionData())
			.memo(v.getMemo())
			.name(v.getName())
			.pic(list.get(0).getThumb())
			.shopId(0)
			.status(1)
			.type(v.getType())
			.typeId(v.getTypeId())
			.typePid(v.getTypePid())
			.minPrice(minMoney)
			.maxPrice(maxMoney)
			.realMinPrice(realMinMoney)
			.realMaxPrice(realMaxMoney)
			.build();
		
		int ret = productDao.insertUseGeneratedKeys(productDO);
		
		//判断是否新增成功
		if(ret < 1){
			return 0;
		}
		
		
		//图片添加
		List<ProductResourceDO> productResourcesList = new ArrayList<ProductResourceDO>();
		
		list.forEach(r -> {
			productResourcesList.add(ProductResourceDO.builder()
					.productId(productDO.getId())
					.addTime(new Date())
					.big(r.getBig())
					.middle(r.getMiddle())
					.origin(r.getOrigin())
					.suffix(r.getSuffix())
					.thumb(r.getThumb())
					.type(r.getType())
					.folder(r.getId().toString())
					.build());
		});
		productResourceDao.insertList(productResourcesList);
		
		//规格添加
		List<ProductDimensionDO> productDimensionDOList = new ArrayList<ProductDimensionDO>();
		
		v.getProducts().forEach(p ->{
			productDimensionDOList.add(ProductDimensionDO.builder()
					.dimensionId(p.getIdArray())
					.dimensionName(p.getNameArray())
					.nums(p.getNums())
					.price(p.getMoney())
					.realPrice(p.getRealMoney())
					.build());
		});
		
		productDimensionDao.insertList(productDimensionDOList);
		
		return ret;
	}
	
}

/**
 * 
 */
package com.personal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.base.controller.BaseController;
import com.personal.product.domain.BrandDO;
import com.personal.product.domain.ProductTypeDO;
import com.personal.product.dto.QueryProductDto;
import com.personal.product.dto.QueryProductTypeDto;
import com.personal.product.service.BrandService;
import com.personal.product.service.ProductService;
import com.personal.product.service.ProductTypeService;
import com.personal.product.service.PromotionService;
import com.personal.vo.Message;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

	@Autowired
	ProductService productService;

	@Autowired
	ProductTypeService productTypeService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	PromotionService promotionService;
	
	
	/**
	 * 商品类型
	 * @param queryProductTypeDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productType")
	public Message getProductTypeList(QueryProductTypeDto queryProductTypeDto){
		Message message = Message.builder().code("200").msg("成功").build();
		List<ProductTypeDO> list = productTypeService.productTypeListLike(ProductTypeDO.builder()
				.pid(queryProductTypeDto.getPid())
				.fullPy(queryProductTypeDto.getFullPy())
				.name(queryProductTypeDto.getName())
				.build());
		message.setData(list);
		
		return message;
	}
	
	/**
	 * 商品列表
	 * @param queryProductDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Message getProductList(QueryProductDto queryProductDto){
		Message message = Message.builder().code("200").msg("成功").build();
		message.setData(productService.list(queryProductDto));
		return message;
	}
	
	
	/**
	 * 品牌列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/brandList")
	public Message getBrandList(){
		Message message = Message.builder().code("200").msg("成功").build();
		message.setData(brandService.list(BrandDO.builder().build()));
		return message;
	}
	
	/**
	 * 活动列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/promotionList")
	public Message getPromotion(){
		Message message = Message.builder().code("200").msg("成功").build();
		message.setData(promotionService.list(null));
		return message;
	}
	
	
}

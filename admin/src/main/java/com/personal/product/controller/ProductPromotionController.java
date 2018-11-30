package com.personal.product.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.common.utils.PageUtils;
import com.personal.common.utils.Query;
import com.personal.common.utils.R;
import com.personal.product.domain.ProductPromotionDO;
import com.personal.product.service.ProductPromotionService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
 
@Controller
@RequestMapping("/product/productPromotion")
public class ProductPromotionController {
	@Autowired
	private ProductPromotionService productPromotionService;
	
	@GetMapping()
	@RequiresPermissions("product:productPromotion:productPromotion")
	String ProductPromotion(){
	    return "product/productPromotion/productPromotion";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:productPromotion:productPromotion")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductPromotionDO> productPromotionList = productPromotionService.list(query);
		int total = productPromotionService.count(query);
		PageUtils pageUtils = new PageUtils(productPromotionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:productPromotion:add")
	String add(){
	    return "product/productPromotion/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:productPromotion:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductPromotionDO productPromotion = productPromotionService.get(id);
		model.addAttribute("productPromotion", productPromotion);
	    return "product/productPromotion/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:productPromotion:add")
	public R save( ProductPromotionDO productPromotion){
		if(productPromotionService.save(productPromotion)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:productPromotion:edit")
	public R update( ProductPromotionDO productPromotion){
		productPromotionService.update(productPromotion);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:productPromotion:remove")
	public R remove( Integer id){
		if(productPromotionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:productPromotion:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		productPromotionService.batchRemove(ids);
		return R.ok();
	}
	
}

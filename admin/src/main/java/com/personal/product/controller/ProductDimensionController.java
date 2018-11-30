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
import com.personal.product.domain.ProductDimensionDO;
import com.personal.product.service.ProductDimensionService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
 
@Controller
@RequestMapping("/product/productDimension")
public class ProductDimensionController {
	@Autowired
	private ProductDimensionService productDimensionService;
	
	@GetMapping()
	@RequiresPermissions("product:productDimension:productDimension")
	String ProductDimension(){
	    return "product/productDimension/productDimension";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:productDimension:productDimension")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDimensionDO> productDimensionList = productDimensionService.list(query);
		int total = productDimensionService.count(query);
		PageUtils pageUtils = new PageUtils(productDimensionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:productDimension:add")
	String add(){
	    return "product/productDimension/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:productDimension:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductDimensionDO productDimension = productDimensionService.get(id);
		model.addAttribute("productDimension", productDimension);
	    return "product/productDimension/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:productDimension:add")
	public R save( ProductDimensionDO productDimension){
		if(productDimensionService.save(productDimension)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:productDimension:edit")
	public R update( ProductDimensionDO productDimension){
		productDimensionService.update(productDimension);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:productDimension:remove")
	public R remove( Integer id){
		if(productDimensionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:productDimension:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		productDimensionService.batchRemove(ids);
		return R.ok();
	}
	
}

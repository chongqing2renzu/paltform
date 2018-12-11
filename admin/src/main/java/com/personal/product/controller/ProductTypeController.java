package com.personal.product.controller;

import java.util.HashMap;
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
import com.personal.product.domain.DimensionDO;
import com.personal.product.domain.ProductTypeDO;
import com.personal.product.service.ProductTypeService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-27 17:27:26
 */
 
@Controller
@RequestMapping("/product/productType")
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@GetMapping()
	@RequiresPermissions("product:productType:productType")
	String ProductType(){
	    return "product/type/productType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:productType:productType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductTypeDO> productTypeList = productTypeService.list(query);
		int total = productTypeService.count(query);
		PageUtils pageUtils = new PageUtils(productTypeList, total);
		return pageUtils;
	}
	
	
	@ResponseBody
	@GetMapping("/listNoPage")
	@RequiresPermissions("product:productType:productType")
	public List<ProductTypeDO> listNoPage(@RequestParam Map<String, Object> params){
		
		//查询列表数据
		List<ProductTypeDO> productTypeList = productTypeService.list(params);
		
		return productTypeList;
	}
	
	
	
	@GetMapping("/add")
	@RequiresPermissions("product:productType:add")
	String add(Model model){
		
		model.addAttribute("typelist", productTypeService.productTypeList(ProductTypeDO.builder().pid(0).build()));
		
	    return "product/type/add";
	}
	
	@GetMapping("/childAdd/{id}")
	@RequiresPermissions("product:productType:childAdd")
	String childAdd(@PathVariable("id") Integer id,Model model){
		
		ProductTypeDO productType = productTypeService.get(id);
		model.addAttribute("productType", productType);
		
	    return "product/type/child_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:productType:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductTypeDO productType = productTypeService.get(id);
		model.addAttribute("productType", productType);
	    return "product/type/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:productType:add")
	public R save( ProductTypeDO productType){
		
		if(productTypeService.save(productType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:productType:edit")
	public R update( ProductTypeDO productType){
		productTypeService.update(productType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:productType:remove")
	public R remove( Integer id){
		if(productTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:productType:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		productTypeService.batchRemove(ids);
		return R.ok();
	}
	
}

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
import com.personal.product.domain.ProductDO;
import com.personal.product.service.DimensionService;
import com.personal.product.service.ProductService;
import com.personal.product.service.ProductTypeService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-29 22:01:07
 */
 
@Controller
@RequestMapping("/product/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DimensionService  dimensionService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@GetMapping()
	@RequiresPermissions("product:product:product")
	String Product(){
	    return "product/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:product:add")
	String add(Model model){
		
		//分类
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid", 0);
		
		model.addAttribute("typeList", productTypeService.list(map));
		//分类所得到的规格
		
		
		//品牌
		
		
	    return "product/product/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:product:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductDO product = productService.get(id);
		model.addAttribute("product", product);
	    return "product/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:product:add")
	public R save( ProductDO product){
		if(productService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:product:edit")
	public R update( ProductDO product){
		productService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:product:remove")
	public R remove( Integer id){
		if(productService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		productService.batchRemove(ids);
		return R.ok();
	}
	
}

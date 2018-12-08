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
import com.personal.product.domain.BrandDO;
import com.personal.product.service.BrandService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:21:42
 */
 
@Controller
@RequestMapping("/product/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@GetMapping()
	@RequiresPermissions("product:brand:brand")
	String Brand(){
	    return "product/brand/brand";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:brand:brand")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BrandDO> brandList = brandService.list(query);
		int total = brandService.count(query);
		PageUtils pageUtils = new PageUtils(brandList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:brand:add")
	String add(){
	    return "product/brand/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:brand:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BrandDO brand = brandService.get(id);
		model.addAttribute("brand", brand);
	    return "product/brand/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:brand:add")
	public R save( BrandDO brand){
		if(brandService.save(brand)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:brand:edit")
	public R update( BrandDO brand){
		brandService.update(brand);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:brand:remove")
	public R remove( Integer id){
		if(brandService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:brand:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		brandService.batchRemove(ids);
		return R.ok();
	}
	
}

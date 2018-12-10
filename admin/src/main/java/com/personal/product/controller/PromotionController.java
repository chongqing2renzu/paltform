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
import com.personal.product.domain.PromotionDO;
import com.personal.product.service.PromotionService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-10 16:23:48
 */
 
@Controller
@RequestMapping("/product/promotion")
public class PromotionController {
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping()
	@RequiresPermissions("product:promotion:promotion")
	String Promotion(){
	    return "product/promotion/promotion";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:promotion:promotion")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PromotionDO> promotionList = promotionService.list(query);
		int total = promotionService.count(query);
		PageUtils pageUtils = new PageUtils(promotionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:promotion:add")
	String add(){
	    return "product/promotion/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:promotion:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PromotionDO promotion = promotionService.get(id);
		model.addAttribute("promotion", promotion);
	    return "product/promotion/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:promotion:add")
	public R save( PromotionDO promotion){
		if(promotionService.save(promotion)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:promotion:edit")
	public R update( PromotionDO promotion){
		promotionService.update(promotion);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:promotion:remove")
	public R remove( Integer id){
		if(promotionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:promotion:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		promotionService.batchRemove(ids);
		return R.ok();
	}
	
}

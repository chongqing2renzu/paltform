package com.personal.banner.controller;

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

import com.personal.banner.domain.BannerDO;
import com.personal.banner.service.BannerService;
import com.personal.common.utils.PageUtils;
import com.personal.common.utils.Query;
import com.personal.common.utils.R;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-10 16:17:42
 */
 
@Controller
@RequestMapping("/banner/banner")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	@GetMapping()
	@RequiresPermissions("banner:banner:banner")
	String Banner(){
	    return "banner/banner";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("banner:banner:banner")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("banner:banner:add")
	String add(){
	    return "banner/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("banner:banner:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BannerDO banner = bannerService.get(id);
		model.addAttribute("banner", banner);
	    return "banner/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("banner:banner:add")
	public R save( BannerDO banner){
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("banner:banner:edit")
	public R update( BannerDO banner){
		bannerService.update(banner);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("banner:banner:remove")
	public R remove( Integer id){
		if(bannerService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("banner:banner:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bannerService.batchRemove(ids);
		return R.ok();
	}
	
}

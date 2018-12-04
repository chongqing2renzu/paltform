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

import com.personal.common.utils.R;
import com.personal.product.domain.DimensionDO;
import com.personal.product.service.DimensionService;
import com.personal.product.service.ProductTypeService;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-02 15:56:54
 */
 
@Controller
@RequestMapping("/product/dimension")
public class DimensionController {
	
	@Autowired
	private DimensionService dimensionService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@GetMapping()
	@RequiresPermissions("product:dimension:dimension")
	String Dimension(){
	    return "product/dimension/dimension";
	}
	
//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("product:dimension:dimension")
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<DimensionDO> dimensionList = dimensionService.list(query);
//		int total = dimensionService.count(query);
//		PageUtils pageUtils = new PageUtils(dimensionList, total);
//		return pageUtils;
//	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:dimension:dimension")
	public List<DimensionDO> list(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<DimensionDO> dimensionList = dimensionService.list(params);
 		return dimensionList;
	}
	
	@ResponseBody
	@GetMapping("/listByType/{typeId}")
	@RequiresPermissions("product:dimension:dimension")
	public List<DimensionDO> listByType(@PathVariable("typeId") Integer typeId){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("typeId", typeId);
		List<DimensionDO> dimensionList = dimensionService.list(params);
 		return dimensionList;
	}
	
//	@ResponseBody
//	@GetMapping("/listNoPage")
//	@RequiresPermissions("product:dimension:dimension")
//	public List<DimensionDO> listNoPage(@RequestParam Map<String, Object> params){
//		//查询列表数据
//		List<DimensionDO> dimensionList = dimensionService.list(params);
// 		return dimensionList;
//	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:dimension:add")
	String add(Integer id,Model model){
		
		if(id != null) {
			DimensionDO dimensionDO = dimensionService.get(id);
			
			model.addAttribute("fdo", dimensionDO);
			
			if(dimensionDO!=null && !dimensionDO.getTypeId().equals(dimensionDO.getTypePid())) {
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("pid", dimensionDO.getTypePid());
				model.addAttribute("childTypeList", productTypeService.list(params));
			}
		}
		
		//类型
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("pid", 0);
		
		
		model.addAttribute("typeList", productTypeService.list(params));
		
	    return "product/dimension/add";
	}
	
	@GetMapping("/childAdd/{id}")
	@RequiresPermissions("product:dimension:childAdd")
	String childAdd(@PathVariable("id") Integer id,Model model){
		
		DimensionDO dimension = dimensionService.get(id);
		model.addAttribute("dimension", dimension);
		
		model.addAttribute("productTypeList", productTypeService.productTypeList(dimension.getTypeId()));
		
	    return "product/dimension/child_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:dimension:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DimensionDO dimension = dimensionService.get(id);
		model.addAttribute("dimension", dimension);
	    return "product/dimension/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:dimension:add")
	public R save( DimensionDO dimension){
		if(dimensionService.save(dimension)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:dimension:edit")
	public R update( DimensionDO dimension){
		dimensionService.update(dimension);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:dimension:remove")
	public R remove( Integer id){
		if(dimensionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:dimension:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		dimensionService.batchRemove(ids);
		return R.ok();
	}
	
}

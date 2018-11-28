package com.personal.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-28 21:21:13
 */
public class ProductDimensionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer productId;
	//
	private Integer dimensionId;
	//
	private BigDecimal price;
	//
	private BigDecimal realPrice;
	//
	private Integer nums;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：
	 */
	public void setDimensionId(Integer dimensionId) {
		this.dimensionId = dimensionId;
	}
	/**
	 * 获取：
	 */
	public Integer getDimensionId() {
		return dimensionId;
	}
	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getRealPrice() {
		return realPrice;
	}
	/**
	 * 设置：
	 */
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	/**
	 * 获取：
	 */
	public Integer getNums() {
		return nums;
	}
}

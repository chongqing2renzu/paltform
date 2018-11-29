package com.personal.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-29 22:01:07
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String memo;
	//
	private String pic;
	//
	private Integer shopId;
	//
	private String dimensionData;
	//
	private BigDecimal minPrice;
	//
	private BigDecimal realMinPrice;
	//
	private BigDecimal maxPrice;
	//
	private BigDecimal realMaxPrice;
	//
	private Integer status;
	//
	private Date addTime;
	//
	private Date updateTime;
	//
	private Integer type;

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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：
	 */
	public void setDimensionData(String dimensionData) {
		this.dimensionData = dimensionData;
	}
	/**
	 * 获取：
	 */
	public String getDimensionData() {
		return dimensionData;
	}
	/**
	 * 设置：
	 */
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	/**
	 * 设置：
	 */
	public void setRealMinPrice(BigDecimal realMinPrice) {
		this.realMinPrice = realMinPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getRealMinPrice() {
		return realMinPrice;
	}
	/**
	 * 设置：
	 */
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	/**
	 * 设置：
	 */
	public void setRealMaxPrice(BigDecimal realMaxPrice) {
		this.realMaxPrice = realMaxPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getRealMaxPrice() {
		return realMaxPrice;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
}

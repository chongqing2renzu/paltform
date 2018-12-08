package com.personal.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-29 22:01:07
 */
@Table(name="bus_product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	@Column(name = "shop_id")
	private Integer shopId;
	//
	@Column(name = "dimension_data")
	private String dimensionData;
	//
	@Column(name = "min_price")
	private BigDecimal minPrice;
	//
	@Column(name = "real_min_price")
	private BigDecimal realMinPrice;
	//
	@Column(name = "max_price")
	private BigDecimal maxPrice;
	//
	@Column(name = "real_max_price")
	private BigDecimal realMaxPrice;
	//
	private Integer status;
	//
	@Column(name = "add_time")
	private Date addTime;
	//
	@Column(name = "update_time")
	private Date updateTime;
	//
	private Integer type;

	@Column(name = "type_pid")
	private Integer typePid;
	
	@Column(name = "type_id")
	private Integer typeId;
	
	@Column(name = "brand_id")
	private Integer brandId;
	
	@Column(name = "brand_name")
	private String brandName;
	 
}

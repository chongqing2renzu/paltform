package com.personal.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * @date 2018-11-28 21:21:13
 */
@Table(name="bus_product_dimension")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDimensionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer productId;
	//
	private String dimensionId;
	//
	private BigDecimal price;
	//
	private BigDecimal realPrice;
	//
	private Integer nums;
	
	private String dimensionName;

	 
}

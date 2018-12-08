package com.personal.product.domain;

import java.io.Serializable;
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
 * @date 2018-12-08 11:21:42
 */
@Table(name ="bus_product_resource")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResourceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	@Column(name="product_id")
	private Integer productId;
	//
	private Integer type;
	//
	private String suffix;
	//
	private String folder;
	//
	private String thumb;
	//
	private String middle;
	//
	private String big;
	//
	private String origin;
	//
	private Date addTime;

}

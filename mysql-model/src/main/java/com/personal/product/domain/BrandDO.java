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
@Table(name = "bus_brand")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String logo;
	//
	private String memo;
	//
	@Column(name ="full_py")
	private String fullPy;
	//
	@Column(name ="short_py")
	private String shortPy;
	//
	private Integer sort;
	//
	@Column(name ="add_time")
	private Date addTime;

}

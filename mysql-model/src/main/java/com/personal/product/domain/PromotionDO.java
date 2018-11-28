package com.personal.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "bus_promotion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String memo;
	//
	private Integer isAll;
	//
	private Integer type;
	//
	private BigDecimal overflow;
	//
	private BigDecimal reduce;
	//
	private BigDecimal discount;
	//
	private Date addTime;
	//
	private Date updateTime;
	//
	private Date startTime;
	//
	private Date endTime;
	//
	private Integer status;

}

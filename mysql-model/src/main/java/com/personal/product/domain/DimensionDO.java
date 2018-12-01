package com.personal.product.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-02 15:56:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DimensionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer pid;
	//
	@Column(name = "type_pid")
	private Integer typePid;
	//
	private Integer typeId;
	//
	private String name;
	//
	private String memo;
	//
	@Column(name = "add_time")
	private Date addTime;
	//
	@Column(name = "update_time")
	private Date updateTime;

	 
}

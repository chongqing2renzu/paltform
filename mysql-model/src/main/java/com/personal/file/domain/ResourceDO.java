package com.personal.file.domain;

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
 * @date 2018-11-30 16:00:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="bus_resource")
public class ResourceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//
	private String origin;
	//
	private String thumb;
	//
	private String middle;
	//
	private String big;
	//
	private String suffix;
	//
	private Integer type;
	//
	@Column(name="add_time")
	private Date addTime;
	//
	private Integer status;

	 
}

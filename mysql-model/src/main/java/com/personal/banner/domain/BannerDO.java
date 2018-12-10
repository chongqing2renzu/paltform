package com.personal.banner.domain;

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
 * @date 2018-12-10 16:17:42
 */
@Table(name = "bus_banner")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String pic;
	//
	private String url;
	//
	private String content;
	//
	@Column(name = "start_time")
	private Date startTime;
	//
	@Column(name = "end_tme")
	private Date endTime;
	//
	@Column(name = "add_tme")
	private Date addTime;
	//
	private Integer status;
	
	@Column(name = "resource_id")
	private Integer resourceId;

	 
}

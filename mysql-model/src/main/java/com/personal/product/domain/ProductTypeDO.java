package com.personal.product.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-11-27 17:27:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pid;

    private String name;

    private String memo;

    private String pic;

    @Column(name = "full_py")
    private String fullPy;

    @Column(name = "short_py")
    private String shortPy;

    private Integer sort;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "update_time")
    private Date updateTime;

}

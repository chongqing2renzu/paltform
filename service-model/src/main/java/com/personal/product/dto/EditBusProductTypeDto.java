/**
 * 
 */
package com.personal.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditBusProductTypeDto {

	private Integer pid;
	private String name;
	private String memo;
	private String pic;
	private Integer sort;
	
	private String fullPy;
	private String shortPy;
	
}

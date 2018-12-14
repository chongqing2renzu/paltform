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
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryProductTypeDto {

	private Integer pid;
	
	private String name;
	
	private String fullPy;
}

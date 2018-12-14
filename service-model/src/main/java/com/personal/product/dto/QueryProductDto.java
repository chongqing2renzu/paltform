/**
 * 
 */
package com.personal.product.dto;

import java.math.BigDecimal;

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
public class QueryProductDto {

	private Integer start;
	private Integer limit;
	
	private Integer typePid;
	private Integer typeId;
	
	private String name;
	
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	
	private Integer priceSort;// 0： 价格升序 1：价格降序    null：不依据他排序
	
	private Integer soldSort; // 0:升序 1：降序 null 不依据它排序
	
}

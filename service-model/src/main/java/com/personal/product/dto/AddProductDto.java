/**
 * 
 */
package com.personal.product.dto;

import java.math.BigDecimal;
import java.util.List;

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
public class AddProductDto {

	private Integer typePid;
	private Integer typeId;
	private String name;
	private List<Integer> imgId;
	private String dimensionData;
//	private List<Product> products;
	private Integer brandId;
	private String brandName;
	private String memo;
	private Integer type;
	private BigDecimal price;
	private BigDecimal realPrice;
	private BigDecimal cash;
	
	
//	@Data
//	@Builder
//	@AllArgsConstructor
//	@NoArgsConstructor
//	public static class Product {
//		 private String nameArray;
//		 private String idArray;
//		 private Integer nums;
//		 private BigDecimal money;
//		 private BigDecimal realMoney;
//	 }
}

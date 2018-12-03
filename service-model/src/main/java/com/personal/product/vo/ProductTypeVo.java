/**
 * 
 */
package com.personal.product.vo;

import java.util.List;

import com.personal.product.domain.ProductTypeDO;

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
public class ProductTypeVo {
	private Integer typeId;
	private Integer pid;
	private List<ProductTypeDO> list;
}

/**
 * 
 */
package com.personal.file.vo;

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
public class ImageVo {

	private String origin;
	private String big;
	private String middle;
	private String thumb;
	
	private String fileName;
	private String suffix;
}

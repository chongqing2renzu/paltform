/**
 * 
 */
package com.personal.vo;

import java.awt.image.BufferedImage;

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
public class RandomImgVo {

	private String code;
	
	private BufferedImage img;
	
}

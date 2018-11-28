/**
 * 
 */
package com.personal.dto;

import javax.validation.constraints.NotBlank;

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
public class LoginDto {

	@NotBlank
	private String account;
	
	@NotBlank
	private String password;
}

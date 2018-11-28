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
public class RegisterDto {

	@NotBlank(message = "账户不能为空")
	private String account;
	
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@NotBlank(message = "验证码不能为空")
	private String capcha;
}

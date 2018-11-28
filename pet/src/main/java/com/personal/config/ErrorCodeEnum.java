/**
 * 
 */
package com.personal.config;

/**
 * @author Administrator
 *
 */
public enum ErrorCodeEnum {
	
	ACCOUNT_EMPTY(40001,"账号不能为空"),
	PASSWORD_EMPTY(40002,"密码不能为空"),
	CAPCHA_EMPTY(40003,"验证码不能为空");
	

	private int code;
	private String msg;
	
	private ErrorCodeEnum(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}

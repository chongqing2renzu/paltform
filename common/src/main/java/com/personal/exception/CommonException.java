package com.personal.exception;

import lombok.Getter;
import lombok.Setter;

public class CommonException extends Exception{
	

	@Getter
	@Setter
	protected String code;

	@Getter
	@Setter
	protected String msg;

	public CommonException(String code,String msg,Throwable e) {
		super(msg, e);
		this.code  = code;
		this.msg  = msg;
	}
	
	public CommonException() {
		
	}
	
	public CommonException(Throwable e) {
        super(e);
    }
	
	
	public CommonException(String code,String msg){
		this(code, msg, null);
	}
	
}

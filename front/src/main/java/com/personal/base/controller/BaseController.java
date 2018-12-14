/**
 * 
 */
package com.personal.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.exception.CommonException;
import com.personal.vo.Message;

/**
 * @author Administrator
 *
 */
public class BaseController {

	@ResponseBody
	@ExceptionHandler(value = { CommonException.class, Exception.class })
	public Message exception(Object e) {
		Message message = Message.builder().build();
		if (e instanceof CommonException) {
			CommonException c = (CommonException) e;
			message.setCode(c.getCode());
			message.setRet(Message.SUCCESS);
			message.setMsg(c.getMsg());
		} else {
			Exception c = (Exception) e;
			message.setCode(Message.REQ_FAILED);
			message.setRet(Message.SUCCESS);
			message.setMsg("数据异常");
			c.printStackTrace();
		}
		return message;
	}

}

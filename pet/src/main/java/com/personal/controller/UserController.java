/**
 * 
 */
package com.personal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "register",method = RequestMethod.GET)
	public ModelAndView registerPage(HttpServletRequest request,
			HttpServletResponse response
			,ModelAndView modelAndView){
		modelAndView.setViewName("user/register");
		return modelAndView;
	}
}

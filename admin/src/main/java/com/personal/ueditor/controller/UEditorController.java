/**
 * 
 */
package com.personal.ueditor.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 *
 */
@Slf4j
@Controller
public class UEditorController {

	@ResponseBody
	@RequestMapping("/config")
	public String config(HttpServletRequest request, HttpServletResponse response){
//		String rootPath = request.getSession().getServletContext().getRealPath("/"); 
		String rootPath = "src/main/resources/static";
		String exec = new ActionEnter(request, rootPath).exec();
		return exec;
	}
}

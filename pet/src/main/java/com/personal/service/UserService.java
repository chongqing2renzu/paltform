/**
 * 
 */
package com.personal.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.data.JRedisUtils;
import com.personal.dto.LoginDto;
import com.personal.dto.RegisterDto;
import com.personal.random.RandomValidateCodeUtil;
import com.personal.vo.RandomImgVo;

/**
 * @author Administrator
 *
 */
@Service
public class UserService {
	
	@Autowired
	JRedisUtils jRedisUtils;

	/**
	 * 注册账户
	 * @param registerDto
	 */
	public void register(RegisterDto registerDto){
		
	}
	
	/**
	 * 登陆账户
	 * @param loginDto
	 */
	public void login(LoginDto loginDto){
		
	}
	
	
	/**
	 * 得到验证码
	 * @param jsessionId
	 * @return
	 */
	public RandomImgVo getRandomImg(String jsessionId){
		RandomImgVo randomImgVo = RandomValidateCodeUtil.getRandCodeImg();
		try {
			jRedisUtils.addValue(jsessionId, randomImgVo.getCode(), 5, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomImgVo;
	}
}

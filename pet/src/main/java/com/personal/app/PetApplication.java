/**
 * 
 */
package com.personal.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 *
 */
@MapperScan("com.personal.mapper")
@ComponentScan("com.personal")
@SpringBootApplication
public class PetApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PetApplication.class, args);
	}

}

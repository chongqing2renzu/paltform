/**
 * 
 */
package com.personal.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.personal.handler.DemoHandler;

/**
 * @author Administrator
 *
 */
@Configuration
public class DemoRouter {

	@Bean
	public RouterFunction<ServerResponse> route(DemoHandler demoHandler){
		return RouterFunctions.route(RequestPredicates.GET("/hello")
				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
				demoHandler::helloWorld);
		
	}
}

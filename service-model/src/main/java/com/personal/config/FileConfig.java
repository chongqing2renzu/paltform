/**
 * 
 */
package com.personal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix="bootdo")
public class FileConfig {

	private String uploadPath;
	
	private String big;
	
	private String thumb;
	
	private String origin;
	
	private String middle;
	
	private String url;
}

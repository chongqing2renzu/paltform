/**
 * 
 */
package com.personal.file.handler;

import java.util.concurrent.Callable;

import com.personal.utils.ImageUtil;

/**
 * @author Administrator
 *
 */
public class FileTask implements Callable<String>{
	
	private String originPath;
	private String newPath;
	private Integer width;
	private Integer height;
	private String  fileName;
	

	public FileTask(String originPath, String newPath, Integer width, Integer height,String fileName) {
		this.originPath = originPath;
		this.newPath = newPath;
		this.width = width;
		this.height = height;
		this.fileName = fileName;
	}


	@Override
	public String call() throws Exception {
		return ImageUtil.reduceImg(originPath, newPath, width, height,fileName);
	}

}

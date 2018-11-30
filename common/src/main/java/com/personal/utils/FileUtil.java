/**
 * 
 */
package com.personal.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author wb
 *
 */
public class FileUtil {
	
	private static List<String> imageType = new ArrayList<String>();
	
	static {
		imageType.addAll(Arrays.asList("jpg","jpeg","png","gif","JPEG","JPG","PNG","GIF"));
	}

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	public static String filesuffix(String  fileName) {

		// 获取文件名的后缀，可以将后缀定义为类变量，共后面的函数使用
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

		// 声明图片后缀名数组
		// if (!suffix.matches("^[(jpg)|(png)|(gif)]+$")) {
		// System.out.println("请输入png,jpg,gif格式的图片");
		// return false;
		// }
		return suffix;
	}
	/**
	 * 根据后缀名得到分类
	 * @param suffix
	 * @return
	 */
	public static Integer fileType(String suffix){
		 if(imageType.contains(suffix)){
			 return 1;
		 }
		 return 0;
	}

}

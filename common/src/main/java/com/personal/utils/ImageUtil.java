/**
 * 
 */
package com.personal.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

/**
 * @author wb
 *
 */
public class ImageUtil {

    /**
     * 指定图片宽度和高度和压缩比例对图片进行压缩
     * 
     * @param imgsrc
     *            源图片地址
     * @param imgdist
     *            目标图片地址
     * @param widthdist
     *            压缩后图片的宽度
     * @param heightdist
     *            压缩后图片的高度
     * @param rate
     *            压缩的比例
     */
    public static String reduceImg(String imgsrc, String imgdist, int widthdist, int heightdist) {
        try {
            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
            
            File targetFile = new File(imgdist);
    		if (!targetFile.exists()) {
    			targetFile.mkdirs();
    		}
            
            // 如果比例不为空则说明是按比例压缩
            //获得源图片的宽高存入数组中
            int[] results = getImgWidthHeight(srcfile);
            //改变的宽高
            BigDecimal changeWidth = new BigDecimal(widthdist);
//            BigDecimal changeHeigth = new BigDecimal(heightdist);
            
            //原宽高
            BigDecimal originWidth = new BigDecimal(results[0]);
            BigDecimal originHeigth = new BigDecimal(results[1]);
            
            BigDecimal rate = changeWidth.divide(originWidth);
            
            
            if (results == null || results[0] == 0 || results[1] == 0) {
                return null;
            } else {
                //按比例缩放或扩大图片大小，将浮点型转为整型
                widthdist = originWidth.multiply(rate).intValue();
                heightdist = originHeigth.multiply(rate).intValue();
            }
            // 开始读取文件并进行压缩
            Image src = ImageIO.read(srcfile);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

            //绘制图像  getScaledInstance表示创建此图像的缩放版本，返回一个新的缩放版本Image,按指定的width,height呈现图像
            //Image.SCALE_SMOOTH,选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);

            //创建文件输出流
            FileOutputStream out = new FileOutputStream(imgdist);
            //将图片按JPEG压缩，保存到out中
            com.sun.image.codec.jpeg.JPEGImageEncoder encoder = com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            //关闭文件输出流
            out.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }
        return imgdist;
    }

    /**
     * 获取图片宽度和高度
     * 
     * @param 图片路径
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] =src.getWidth(null); // 得到源图片宽
            result[1] =src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        
        File srcfile = new File("f://img//1.jpg"); 
        
        
        System.out.println("压缩前图片大小：" + srcfile.length());
        reduceImg("f://img//1.jpg", "f://img//12.jpg", 1024, 1024);
        File distfile = new File("f://img//12.jpg");
        System.out.println("压缩后图片大小：" + distfile.length());

    }
    
}

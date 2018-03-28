/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.qrcode
 * 创建时间：2017年8月10日上午9:56:51
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.qrcode;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
  
  
public class EncoderHandler {  
	
	public static int defaultWidthAndHeight=260;  
	
    public void encoderQRCoder(HttpServletRequest request, HttpServletResponse response) throws Exception { 
    	//生成参数
		String uuid = generateUUID();
	    String url = "www.etohui.com?" + uuid;
	    //logger.info("【二维码内容】：{}，【uuid】{}", url, uuid);
        
        //生成二维码
	    Map<EncodeHintType, Object>  hints=new HashMap<EncodeHintType, Object>();
        // 指定纠错等级  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        // 指定编码格式  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        hints.put(EncodeHintType.MARGIN, 1);
        try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url,BarcodeFormat.QR_CODE, defaultWidthAndHeight, defaultWidthAndHeight, hints);
			OutputStream out = response.getOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", out);//输出二维码
            out.flush();
            out.close();
            
        } catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
    
  //唯一标识符
  	public static String generateUUID() {
  		String uuid = UUID.randomUUID().toString();
  		uuid = uuid.replace("-", "");
  		Long currentTime = System.currentTimeMillis();
  		String currentDate = String.valueOf(currentTime);
  		return uuid + currentDate;
  	}
}  
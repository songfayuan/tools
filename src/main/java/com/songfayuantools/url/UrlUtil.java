/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.url
 * 创建时间：2018年1月12日下午4:24:46
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.url;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 描述：在JavaWeb项目中URL中字符串加密解密方案
 * @author songfayuan
 * 2018年1月12日下午4:24:46
 */
public class UrlUtil {
	
	private static final String KEY = "myMw6qPt&3AD";
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);
	
	public static void main(String[] args) throws Exception {
		String source = "pwd=songfayuan";
		System.out.println("加密前：" + source);
		
		String result = enCryptAndEncode(source);
		System.out.println("加密后：" + result);
		
		String source_2 = deCryptAndDecode(result);
        System.out.println("解密后:" + source_2);
        
        String isSuccess = source.equals(source_2) ? "Success" : "fail";
        System.out.println("Result:" + isSuccess);
	}
	
	public static String enCryptAndEncode(String content){
		try {
			byte[] sourceBytes = enCryptAndEncode(content, KEY);
			return Base64.encodeBase64URLSafeString(sourceBytes);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return content;
		}
	}
	
	public static String deCryptAndDecode(String content) throws Exception {
		byte[] targetBytes = Base64.decodeBase64(content);
		return deCryptAndDecode(targetBytes, KEY);
	}
	
	/**
	 * 描述：加密函数
	 * @param content 加密内容
	 * @param key 秘钥
	 * @return 返回二进制字符数组
	 * @throws Exception
	 * @author songfayuan
	 * 2018年1月12日下午4:38:22
	 */
	public static byte[] enCryptAndEncode(String content, String key) throws Exception {
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(key.getBytes()));
		
		SecretKey deSecretKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, deSecretKey);
		return cipher.doFinal(content.getBytes("UTF-8"));
	}
	
	/**
	 * 描述：解密函数
	 * @param src 加密过的二进制字符串
	 * @param key 秘钥
	 * @return
	 * @throws Exception
	 * @author songfayuan
	 * 2018年1月12日下午5:13:14
	 */
	public static String deCryptAndDecode(byte[] src, String key) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(key.getBytes()));
		
		SecretKey deSecretKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, deSecretKey);
		byte[] cByte = cipher.doFinal(src);
		return new String(cByte, "UTF-8");
	}

}

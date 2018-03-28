/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.json
 * 创建时间：2017年7月31日上午11:58:51
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.json;

import com.songfayuantools.entity.UserInfo;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * 描述：JSONObject使用方法详解
 * 	   JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包。
 * @author songfayuan
 * 2017年7月31日上午11:58:51
 */
public class Json {

	/**
	 * 描述：json字符串转java代码
	 * @author songfayuan
	 * 2017年8月2日下午2:24:47
	 */
	public static void jsonToJava() {
		System.out.println("json字符串转java代码");
		String jsonStr = "{\"password\":\"123456\",\"username\":\"张三\"}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		System.err.println("json--->java \n username="+username+"\t passwor="+password);
	}
	
	/**
	 * 描述：java代码封装为json字符串
	 * @author songfayuan
	 * 2017年8月2日下午2:30:58
	 */
	public static void javaToJSON() {
		System.out.println("java代码封装为json字符串");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "宋发元");
		jsonObject.put("age", 24);
		jsonObject.put("sex", "男");
		System.out.println("java--->json \n " + jsonObject.toString());
	}
	
	/**
	 * 描述：json字符串转xml字符串
	 * @author songfayuan
	 * 2017年8月2日下午2:56:30
	 */
	public static void jsonToXML() {
		System.out.println("json字符串转xml字符串");
		String jsonStr = "{\"username\":\"宋发元\",\"password\":\"123456\",\"age\":\"24\"}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setRootName("user_info");
		xmlSerializer.setTypeHintsEnabled(false);
		String xml = xmlSerializer.write(jsonObject);
		System.out.println("json--->xml \n" + xml);
	}
	
	/**
	 * 描述：xml字符串转json字符串
	 * @author songfayuan
	 * 2017年8月2日下午3:19:25
	 */
	public static void xmlToJSON() {
		System.out.println("xml字符串转json字符串");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user_info><password>123456</password><username>宋发元</username></user_info>";
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xml);
		System.out.println("xml--->json \n" + json.toString());
	}
	
	/**
	 * 描述：javaBean转json字符串
	 * @author songfayuan
	 * 2017年8月2日下午3:39:10
	 */
	public static void javaBeanToJSON() {
		System.out.println("javaBean转json字符串");
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("宋发元");
		userInfo.setPassword("123456");
		JSONObject jsonObject = JSONObject.fromObject(userInfo);
		System.out.println("JavaBean-->json \n" + jsonObject.toString());
	}
	
	/**
	 * 描述：javaBean转xml字符串
	 * @author songfayuan
	 * 2017年8月2日下午3:48:08
	 */
	public static void javaBeanToXML() {
		System.out.println("javaBean转xml字符串");
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("songfayuan");
		userInfo.setPassword("66666");
		JSONObject jsonObject = JSONObject.fromObject(userInfo);
		XMLSerializer xmlSerializer = new XMLSerializer();
		String xml = xmlSerializer.write(jsonObject, "UTF-8");
		System.out.println("javaBean--->xml \n" + xml);
	}
	
	public static void main(String args[]) {
//		jsonToJava();
//		javaToJSON();
//		jsonToXML();
//		xmlToJSON();
//		javaBeanToJSON();
		javaBeanToXML();
	}
	
}

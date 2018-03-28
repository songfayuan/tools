/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.uuid
 * 创建时间：2017年8月10日上午9:00:53
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.uuid;

import java.util.UUID;

/**
 * 描述：
 * @author songfayuan
 * 2017年8月10日上午9:00:53
 */
public class GenerateUUID {

	/**
	 * 描述：
	 * @param args
	 * @author songfayuan
	 * 2017年8月10日上午9:00:53
	 */
	public static void main(String[] args) {
		System.out.println(generateUUID());
	}
	
	//uuid+时间戳
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		Long currentTime = System.currentTimeMillis();
		String currentDate = String.valueOf(currentTime);
		return uuid + currentDate;
	}

}

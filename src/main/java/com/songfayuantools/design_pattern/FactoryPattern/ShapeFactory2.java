/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.design_pattern.FactoryPattern
 * 创建时间：2018年3月13日下午3:30:30
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.design_pattern.FactoryPattern;

/**
 * 描述：
 * @author songfayuan
 * 2018年3月13日下午3:30:30
 */
public class ShapeFactory2 {

	public static Object getClass(Class<? extends Shape> clazz){
		Object obj = null;
		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}

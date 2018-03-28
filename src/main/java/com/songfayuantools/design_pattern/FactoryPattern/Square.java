/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.design_pattern.FactoryPattern
 * 创建时间：2018年3月13日上午11:12:21
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.design_pattern.FactoryPattern;

/**
 * 描述：2.创建实现接口的实体类
 * @author songfayuan
 * 2018年3月13日上午11:12:21
 */
public class Square implements Shape {

	/* 
	 * 描述：
	 * (non-Javadoc)
	 * @author songfayuan
	 * 2018年3月13日上午11:12:21
	 * @see com.songfayuantools.design_pattern.FactoryPattern.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Square :: draw() method.");
	}

}

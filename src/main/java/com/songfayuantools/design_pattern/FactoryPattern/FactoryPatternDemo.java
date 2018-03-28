/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.design_pattern.FactoryPattern
 * 创建时间：2018年3月13日上午11:53:53
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.design_pattern.FactoryPattern;

/**
 * 描述：4.使用该工厂，通过传递类型信息来获取实体类对象
 * @author songfayuan
 * 2018年3月13日上午11:53:53
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		//获取Circle的对象，并调用他的draw方法
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		
		//调用Circle的调用draw方法
		shape1.draw();
		
		//获取Rectangle的对象，并调用他的draw方法
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		
		//调用Rectangle的draw方法
		shape2.draw();
		
		//获取Square的对象，并调用他的draw方法
		Shape shape3 = shapeFactory.getShape("SQUARE");
		
		//调用Square的draw方法
		shape3.draw();
		
	}
	
}

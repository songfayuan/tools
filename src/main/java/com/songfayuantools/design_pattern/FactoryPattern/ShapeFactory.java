/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.design_pattern.FactoryPattern
 * 创建时间：2018年3月13日上午11:13:59
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.design_pattern.FactoryPattern;

/**
 * 描述：3.创建一个工厂，生成基于给定信息的实体类对象
 * @author songfayuan
 * 2018年3月13日上午11:13:59
 */
public class ShapeFactory {

	//使用getShape方法获取形状类型的对象
	public Shape getShape(String shapeType){
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
	
}

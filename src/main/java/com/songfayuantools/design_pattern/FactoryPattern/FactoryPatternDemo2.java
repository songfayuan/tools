/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.design_pattern.FactoryPattern
 * 创建时间：2018年3月13日下午3:39:26
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.design_pattern.FactoryPattern;

/**
 * 描述：
 * @author songfayuan
 * 2018年3月13日下午3:39:26
 */
public class FactoryPatternDemo2 {

	public static void main(String[] args) {
		Rectangle rectangle = (Rectangle) ShapeFactory2.getClass(Rectangle.class);
		rectangle.draw();
		Square square = (Square) ShapeFactory2.getClass(Square.class);
		square.draw();
		Circle circle = (Circle) ShapeFactory2.getClass(Circle.class);
		circle.draw();
	}

}

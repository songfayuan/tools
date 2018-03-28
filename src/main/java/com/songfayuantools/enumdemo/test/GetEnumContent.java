/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.enumdemo.test
 * 创建时间：2017年8月15日下午2:32:46
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.enumdemo.test;

import com.songfayuantools.enumdemo.Color;

/**
 * 描述：测试类
 * @author songfayuan
 * 2017年8月15日下午2:32:46
 */
public class GetEnumContent {

	public static void main(String[] args) {
		Color color = Color.BLUE;   //取出蓝色
		System.out.println(color);
		System.out.println("=============分割线=============\n");
		
		for (Color c : Color.values()) {  //枚举.values()表示得到全部枚举内容
			System.out.println(c);
		}
		System.out.println("=============分割线=============\n");
		
		for (Color c : Color.values()) {
			print(c);
		}
	}
	
	public static void print(Color color) {
		switch (color) {  //判断每个颜色
		case RED:                        //直接判断枚举内容
			System.out.println("红色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		default:
			System.out.println("未知颜色");
			break;
		}
	}

}

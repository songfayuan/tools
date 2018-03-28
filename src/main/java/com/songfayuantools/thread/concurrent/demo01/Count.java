/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo01
 * 创建时间：2018年1月18日下午5:27:32
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo01;

/**
 * 描述： 在这个类中的increment方法是累加num值，步长为1。
 * @author songfayuan
 * 2018年1月18日下午5:27:32
 */
public class Count {
	private int num;
	public void increment(){
		num ++;
	}
	public int get() {
		return num;
	}
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo02
 * 创建时间：2018年1月19日下午3:49:14
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo02;

/**
 * 描述：volatile是java的第二种同步机制，一个变量可以被volatile修饰，在这种情况下内存模型（主内存和线程工作内存）确保所有线程可以看到一致的变量值。
 * @author songfayuan
 * 2018年1月19日下午3:49:14
 */
public class TraditionalThreadVolatile {
	
	static volatile int i = 0, j = 0;
	static void one(){
		i++;
		j++;
	}
	static void two(){
		System.out.println("i=" + i + " j=" + j);
	}
	
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				one();
				two();
			}
		}.start();
		new Thread(){
			public void run() {
				one();
				two();
			}
		}.start();
	}
}

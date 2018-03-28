/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo02
 * 创建时间：2018年1月18日上午11:30:07
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.demo02;

/**
 * 描述：
 * @author songfayuan
 * 2018年1月18日上午11:30:07
 */
public class Thread3 {

	/**
	 * 描述：当一个线程访问对象的一个同步代码块时，其他线程对对象中所有的其他同步代码块的访问将被阻塞
	 * @param args
	 * @author songfayuan
	 * 2018年1月18日上午11:32:53
	 */
	public static void main(String[] args) {
		Thread3 myt2 = new Thread3();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				myt2.m4t1();
			}
		}, "*t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				myt2.m4t2();
			}
		}, "-->t2");
		
		t1.start();
		t2.start();
	}
	
	private void m4t1() {
		synchronized (this) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void m4t2() {
		synchronized (this) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

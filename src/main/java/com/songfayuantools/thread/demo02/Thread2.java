/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo02
 * 创建时间：2018年1月18日上午10:05:53
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.demo02;

/**
 * 描述：
 * @author songfayuan
 * 2018年1月18日上午10:05:53
 */
public class Thread2 implements Runnable {

	/* 
	 * 描述：当一个线程访问对象的一个同步代码块时，另一个线程仍然可以访问该对象中的非同步代码块
	 * (non-Javadoc)
	 * @author songfayuan
	 * 2018年1月18日上午10:05:54
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
	}
	
	private void m4t1() {
		synchronized (this) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName()+" " +i);
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void m4t2() {
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
	
	public static void main(String[] args) {
		final Thread2 myt2 = new Thread2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				myt2.m4t1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				myt2.m4t2();
			}
		}, "t2");
		
		t1.start();
		t2.start();
		
	}

}

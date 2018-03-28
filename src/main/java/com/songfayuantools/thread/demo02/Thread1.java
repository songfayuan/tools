/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo02
 * 创建时间：2018年1月18日上午9:51:56
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.demo02;

/**
 * 描述：
 * @author songfayuan
 * 2018年1月18日上午9:51:56
 */
public class Thread1 implements Runnable {

	/* 
	 * 描述：当两个并发线程访问同一个对象中的同步代码块时，一个时间内只能有一个线程得到执行
	 * 另一个线程必须等待当前线程执行完这个代码块后才能执行该代码块
	 * (non-Javadoc)
	 * @author songfayuan
	 * 2018年1月18日上午9:51:56
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"synchronized loop"+i);
			}
		}
	}
	
	public static void main(String[] args) {
		Thread1 thread1  = new Thread1();
		Thread ta = new Thread(thread1,"A");
		Thread tb = new Thread(thread1,"B");
		Thread tc = new Thread(thread1,"C");
		ta.start();
		tb.start();
		tc.start();
	}

}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo04
 * 创建时间：2018年1月21日下午5:03:42
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo04;

/**
 * 描述：线程中断-->isInterrupted()方法可以得到线程的状态。
 * @author songfayuan
 * 2018年1月21日下午5:03:42
 */
public class InterruptTest {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread thread = new MyThread("MyThread");
		thread.start();
		Thread.sleep(100);  //睡眠100毫秒
		thread.interrupt();  //中断线程
	}	
	
}

class MyThread extends Thread{
	int i = 0;

	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while (!isInterrupted()) {  //当前线程没有被中断，则执行
			System.out.println(getName() + getId() + "执行了" + ++i + "次");
		}
	}
}
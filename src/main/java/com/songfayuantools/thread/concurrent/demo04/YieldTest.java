/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo04
 * 创建时间：2018年1月22日上午9:54:08
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo04;

/**
 * 描述：线程让步-->yield()方法暂停当前正在执行的线程对象，并执行其他线程。
 * @author songfayuan
 * 2018年1月22日上午9:54:08
 */
public class YieldTest {
	
	public static void main(String[] args) throws InterruptedException {
		//创建线程对象
		YieldThread t1 = new YieldThread("t1");
		YieldThread t2 = new YieldThread("t2");
		//启动线程
		t1.start();
		t2.start();
		//主线程休眠100毫秒
		Thread.sleep(100);
		//终止线程
		t1.interrupt();
		t2.interrupt();
	}
	
}

class YieldThread extends Thread{
	int i = 0;
	
	public YieldThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while (!isInterrupted()) {  //当前线程没有被中断，则执行
			System.out.println(getName() + "执行了" + ++i + "次");
			if (i % 10 == 0) {  //当i能对10整除时，线程让步
				Thread.yield();
			}
		}
	}
}
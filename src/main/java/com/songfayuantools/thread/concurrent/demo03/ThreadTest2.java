/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo03
 * 创建时间：2018年1月21日下午3:57:36
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo03;

/**
 * 描述：子线程循环10次，主线程循环100次，如此循环100次
 * 
 * 		wait和notify方法必须工作于synchronized内部，且这两个方法只能由锁对象来调用。
 * 
 * @author songfayuan
 * 2018年1月21日下午3:57:36
 */
public class ThreadTest2 {
	
	//主方法
	public static void main(String[] args) {   
		Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "main");
			}
		}).start();
//		threadExecute(business, "main");
	}
	//执行100次
	public static void threadExecute(Business business, String threadType){
		for (int loop = 0; loop < 100; loop++) {
			try {
				if ("main".equals(threadType)) {  
					business.main(loop);//主线程执行
				}else {
					business.sub(loop);//子线程执行
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Business {
	private boolean bool = true;
	//循环100次
	public synchronized void main(int loop) throws InterruptedException{
		while (bool){
			this.wait();
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("main thread seq of " + i + ", loop of " + loop);
		}
		bool = true;
		this.notify();
	}
	//循环10次
	public  synchronized  void sub(int loop) throws InterruptedException{
		while (!bool){
			this.wait();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("-->sub thread seq of " + i + ", loop of " + loop);
		}
		bool = false;
		this.notify();
	}
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo09
 * 创建时间：2018年1月25日下午6:08:08
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：Condition-线程通信更高效的方式
 * 需求：子线程循环10次，主线程循环100次，如此循环100次
 * 知识点：在Condition中，用await()替换wait()，用signal()替换notify()，用signalAll()替换notifyAll()，传统线程的通信方式，Condition都可以实现，但是应该注意，Condition是被绑定到Lock上的，
 * 		要创建一个Lock的Condition必须用newCondition()方法。
 * 
 * 		Condition的强大之处在于他可以为多个线程间建立不同的Condition。
 * @author songfayuan
 * 2018年1月25日下午6:08:08
 */
public class ConcurrentConditionTest {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				threadExecute(business, "sub");
			}
		}).start();
		
		threadExecute(business, "main");
	}
	public static void threadExecute(Business business, String threadType) {
		for (int i = 0; i < 100; i++) {
			try {
				if ("main".equals(threadType)) {
					business.main(i);
				}else {
					business.sub(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Business {
	private boolean bool = true;
	private Lock lock = new ReentrantLock();  //锁对象
	private Condition condition = lock.newCondition();
	public /*synchronized*/ void main(int loop) throws InterruptedException{
		lock.lock(); //获得锁
		try {
			while (bool) {
				//Causes the current thread to wait until it is signalled or interrupted. 
				condition.await();  //this.wait();
			}
			for (int i = 0; i < 100; i++) {
				System.out.println("main thread seq of " + i + ", loop of " + loop);
			}
			bool = true;
			//Wakes up one waiting thread. 
			condition.signal();  //this.notify()  
		} finally {
			lock.unlock();  //释放锁
		}
	}
	
	public /*synchronized*/ void sub(int loop) throws InterruptedException {
		lock.lock();
		try {
			while (!bool) {
				//Causes the current thread to wait until it is signalled or interrupted. 
				condition.await(); //this.wait();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("sub thread seq of " +  i + ", loop of  " + loop);
			}
			bool = false;
			//Wakes up one waiting thread. 
			condition.signal(); //this.notify();     
		} finally {
			lock.unlock();
		}
	}
}
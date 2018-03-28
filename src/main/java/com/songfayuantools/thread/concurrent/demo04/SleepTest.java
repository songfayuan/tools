/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo04
 * 创建时间：2018年1月22日上午10:22:36
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo04;

/**
 * 描述：线程睡眠-->sleep() 线程睡眠的过程中，如果是在synchronized线程同步内，是持有锁的，也就是说，线程是关门睡觉的，别的线程进不来。
 * @author songfayuan
 * 2018年1月22日上午10:22:36
 */
public class SleepTest {
		
	public static void main(String[] args) {
		//创建共享对象
		Service service = new Service();
		//创建线程
		SleepThread t1 = new SleepThread("t1", service);
		SleepThread t2 = new SleepThread("t2", service);
		//启动线程
		t1.start();
		t2.start();
	}
		
}

class SleepThread extends Thread{
	private Service service;
	public SleepThread(String name, Service service) {
		super(name);
		this.service = service;
	}
	@Override
	public void run() {
		service.calc();
	}
}

class Service{
	public synchronized void calc(){
		System.out.println(Thread.currentThread().getName() + "准备计算");
		System.out.println(Thread.currentThread().getName() + "感觉累了，开始睡觉");
		try {
			Thread.sleep(10000); //睡眠10秒
		} catch (Exception e) {
			return;
		}
		System.out.println(Thread.currentThread().getName() + "睡醒了，开始计算");
		System.out.println(Thread.currentThread().getName() + "计算完成");
	}
}

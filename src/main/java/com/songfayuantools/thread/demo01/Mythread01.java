/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo01
 * 创建时间：2017年8月30日下午10:19:33
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：Java多线程【统计所有子进程执行完毕总共的耗时】--让主线程等待所有子线程执行完毕
 * 
 *   【解决思路】：用一个List属性保存所有产生的线程,这样只要判断这个List是否为空就知道还有没有子线程没有执行完了
 *   
 *   main线程是等所有子线程全部执行完后才开始执行的。 
 * 
 * 	  【存在缺点】：如果线程1开始并且结束了,而其他线程还没有开始此时runningThreads的size也为0,主线程会以为所有线程都执行完了。
 *         解决办法是用一个非简单类型的计数器来取代List型的runningThreads,并且在线程创建之前就应该设定好计数器的值。 
 * 
 * @author songfayuan 2017年8月30日下午10:19:33
 */
public class Mythread01 extends Thread {
	
	private static List<Thread> runningThreads = new ArrayList<Thread>();

	public Mythread01() {
	}

	@Override
	public void run() {
		regist(this);// 线程开始时注册
		System.out.println(Thread.currentThread().getName() + "开始...");// 打印开始标记
		// 做一些事情... ...
		unRegist(this);// 线程结束时取消注册
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
	}

	//向list添加线程
	public void regist(Thread t) {
		synchronized (runningThreads) {
			runningThreads.add(t);
		}
	}

	//从list移除保存的线程
	public void unRegist(Thread t) {
		synchronized (runningThreads) {
			runningThreads.remove(t);
		}
	}

	//判断list中的线程是否为空
	public static boolean hasThreadRunning() {
		return (runningThreads.size() > 0);// 通过判断runningThreads是否为空就能知道是否还有线程未执行完
	}
	
	//主方法
	public static void main(String args[]) {
		Integer threadNum = 10; //线程数量
		long tStart = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + "开始");// 打印开始标记
		for (int ii = 0; ii < threadNum; ii++) {// 开threadNum个线程
			Thread t = new Mythread01();
			t.start(); //启动线程
		}
		while (true) {//等待所有子线程执行完
			if (!Mythread01.hasThreadRunning()) {  //判断list中线程是否为空
				break;
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
		long tEnd = System.currentTimeMillis();
		System.out.println("总共用时:" + (tEnd - tStart) + "millions");
	}
}

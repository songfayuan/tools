/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo01
 * 创建时间：2018年1月18日下午5:29:57
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：非线程安全案例
 * @author songfayuan
 * 2018年1月18日下午5:29:57
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		Count count = new Count();
		
		//做一万次加法
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					count.increment();
					//System.out.println(Thread.currentThread().getName()+"--->"+count.get());
				}
			}
		};
		
		//启动10个线程
		List<Thread> threads = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(runnable);
			threads.add(thread);
			thread.start();
		}
		
		//所有线程运行结束
		while (true) { 
			if (allThreadTerminated(threads)) {
				System.out.println(count.get());
				break;
			}
		}
	}	
	
	//判断所有线程是否运行结束
	private static boolean allThreadTerminated(List<Thread> threads){
		for (Thread thread : threads) {
			if (thread.isAlive()) {
				return false;
			}
		}
		return true;
	}
	
}

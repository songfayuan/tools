/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo06
 * 创建时间：2018年1月22日下午4:17:59
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：线程池
 * @author songfayuan
 * 2018年1月22日下午4:17:59
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		/*【知识点】在FixedThreadPool中，有一个固定大小的池，如果当前需要执行的任务超过了池大小,那么多余的任务处于等待状态，直到有空闲下来的线程执行任务，而当执行的任务小于池大小，空闲的线程也不会去销毁。*/		
		//ExecutorService threadPool = Executors.newFixedThreadPool(2); //创建一个固定线程池，容量为2。  
		
		/*【知识点】CachedThreadPool会创建一个缓存区，将初始化的线程缓存起来，如果线程有可用的，就使用之前创建好的线程，如果没有可用的，就创建新线程，终止并且从缓存中移除已有50秒未被使用的线程*/
		//ExecutorService threadPool = Executors.newCachedThreadPool(); //创建一个缓存线程
		
		/*【知识点】SingleThreadExecutor得到的是一个单个的线程，这个线程会保证你的任务执行完成，如果当前线程意外终止，会创建一个新线程继续执行任务*/
		ExecutorService threadPool = Executors.newSingleThreadExecutor(); //创建一个单个线程
		for (int i = 0; i < 5; i++) {
			int taskID = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						try {
							Thread.sleep(20);  //睡眠20毫秒
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "第" + taskID +"次任务的第" + j + "次执行");
					}
				}
			});
		}
		threadPool.shutdown();  //任务执行完毕，关闭线程池
	}
	
}

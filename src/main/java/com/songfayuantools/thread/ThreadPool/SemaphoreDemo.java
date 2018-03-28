/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.ThreadPool
 * 创建时间：2017年9月4日下午1:33:11
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 描述：模拟大家排队上厕所，厕所只有两个位置，来了10个人需要排队。
 * 	
 * Semaphore
 * 一个计数信号量。从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。
 * Semaphore 通常用于限制可以访问某些资源（物理或逻辑的）的线程数目。
 * 
 * @author songfayuan
 * 2017年9月4日下午1:33:11
 */
public class SemaphoreDemo extends Thread {

	private int id;
	
	Semaphore position;
	
	public SemaphoreDemo(int id, Semaphore semaphore) {
		this.id = id;
		this.position = semaphore;
	}
	
	public void run() {
		try {
			if (position.availablePermits() > 0) {
				System.out.println("顾客【" + this.id + "】进入厕所，有空位...");
			} else {
				System.out.println("顾客【"+this.id+"】进入厕所，没空位，排队...");
			}
			position.acquire();
			System.out.println("顾客【"+this.id+"】获得坑位...");
			Thread.sleep(1000);
			System.out.println("顾客【"+this.id+"】使用坑位完毕...");
			position.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService list = Executors.newCachedThreadPool();
		Semaphore position = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			list.submit(new SemaphoreDemo(i+1, position));
		}
		list.shutdown();
		position.acquireUninterruptibly(2);
		System.out.println("使用完毕，需要清扫了...");
		position.release(2);
	}

}

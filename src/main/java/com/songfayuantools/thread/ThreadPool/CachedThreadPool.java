/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.ThreadPool
 * 创建时间：2017年9月3日上午10:23:11
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * @author songfayuan
 * 2017年9月3日上午10:25:47
 */
public class CachedThreadPool {
	
	public static void main(String[] args) {
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
		
	}
	
}
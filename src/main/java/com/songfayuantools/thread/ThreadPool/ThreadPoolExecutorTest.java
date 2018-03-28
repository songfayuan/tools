/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.ThreadPool
 * 创建时间：2017年9月3日上午10:42:16
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：
 * @author songfayuan
 * 2017年9月3日上午10:42:16
 */
public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						while (true) {
							System.out.println(index);
							Thread.sleep(10 * 1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.ThreadPool
 * 创建时间：2017年9月4日下午3:02:34
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述：
 * @author songfayuan
 * 2017年9月4日下午3:02:34
 */
public class BlockingQueueDemo extends Thread {

	public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(3);
	
	private int index;
	
	public BlockingQueueDemo(int index) {
		this.index = index;
	}
	
	public void run() {
		try {
			queue.put(String.valueOf(this.index));
			System.out.println("{" + this.index + "} in queue!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new BlockingQueueDemo(i));
		}
		Thread thread = new Thread(){
			public void run() {
				try {
					while (true) {
						Thread.sleep(1000);
						if (BlockingQueueDemo.queue.isEmpty()) {
							break;
						}
						String str = BlockingQueueDemo.queue.take();
						System.out.println(str + " has take! ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		service.submit(thread);
		service.shutdown();
		
	}

}

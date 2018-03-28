/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo07
 * 创建时间：2018年1月22日下午7:35:27
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo07;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 描述：ExecutorService继承自Executor，他的目的是为我们管理Thread对象，从而简化并发编程，Executor使我们无需显示的去管理线程的生命周期。
 * @author songfayuan
 * 2018年1月22日下午7:35:27
 */
public class CallableAndFuture2 {
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return new Random().nextInt(100);
			}
		});
		
		try {
			Thread.sleep(5000);
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		threadPool.shutdown();
	}	
	
}

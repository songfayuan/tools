/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo07
 * 创建时间：2018年1月22日下午7:59:24
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo07;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：执行多个带返回值的任务，并取得多个返回值。
 * @author songfayuan
 * 2018年1月22日下午7:59:24
 */
public class CallableAndFuture3 {

	public static void main(String[] args) {
		ExecutorService threadPool  = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		for (int i = 0; i < 5; i++) {
			final int taskID = i;
			cs.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return taskID;
				}
			});
		}
		
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

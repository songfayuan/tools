/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo07
 * 创建时间：2018年1月22日下午6:49:34
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo07;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 描述：Callable接口类似于Runnable，但Runnable不会返回结果，并且无法抛出返回结果的异常。
 * 	         而Callable功能更强大一些，被线程执行后，可以返回值，这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的返回值。
 * @author songfayuan
 * 2018年1月22日下午6:49:34
 */
public class CallableAndFuture {
	
	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return new Random().nextInt(100);
			}
		};
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		try {
			Thread.sleep(1000);  //做一些事情
			System.out.println(futureTask.get());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
}

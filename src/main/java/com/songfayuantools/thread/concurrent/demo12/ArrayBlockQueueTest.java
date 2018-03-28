/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo12
 * 创建时间：2018年1月31日上午11:09:21
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 描述：ArrayBlockQueue实现生产者/消费者模式
 * @author songfayuan
 * 2018年1月31日上午11:09:21
 */
public class ArrayBlockQueueTest {
	
	/** 装鸡蛋的盘子，大小为5 */
	private BlockingQueue<Object> eggs = new ArrayBlockingQueue<Object>(5);	
	
	/** 放鸡蛋 */
	public void putEgg(Object egg) {
		try {
			eggs.put(egg);  //向盘子末尾放一个鸡蛋，如果盘子满了，当前线程阻塞
		} catch (Exception e) {
			e.printStackTrace();
		}
		//下面输出有时不太准确，因为与put操作不是一个原子操作
		System.out.println("放入鸡蛋");
	}
	
	private Object getEgg() {
		Object egg = null;
		try {
			egg = eggs.take(); //从盘子开始取一个鸡蛋，如果盘子空了，当前线程阻塞
		} catch (Exception e) {
			e.printStackTrace();
		}
		//下面输出有时候不准确，因为与take操作不是一个原子操作
		System.out.println("拿到鸡蛋");
		return egg;
	}
	
	/** 放鸡蛋线程 */	
	static class AddThread extends Thread{
		private ArrayBlockQueueTest plate;
		private Object egg = new Object();
		public AddThread(ArrayBlockQueueTest plate) {
			this.plate = plate;
		}
		
		@Override
		public void run() {
			plate.putEgg(egg);
		}
	}
	
	/** 取鸡蛋线程 */
	static class GetThread extends Thread{
		private ArrayBlockQueueTest plate;
		public GetThread(ArrayBlockQueueTest plate) {
			this.plate = plate;
		}
		
		@Override
		public void run() {
			plate.getEgg();
		}
	}
	
	public static void main(String[] args) {
		ArrayBlockQueueTest plate = new ArrayBlockQueueTest();
		//先启动10个线程放鸡蛋
		for (int i = 0; i < 10; i++) {
			new Thread(new AddThread(plate)).start();
		}
		
		//再启动10个线程取鸡蛋
		for (int i = 0; i < 10; i++) {
			new Thread(new GetThread(plate)).start();
		}
	}
	
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo09
 * 创建时间：2018年1月27日下午2:37:22
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：实现多个 线程往缓存区存取数据
 * @author songfayuan
 * 2018年1月27日下午2:37:22
 */
public class ConcurrentConditionTest02 {
	public static void main(String[] args) {
		final BoundedBuffer buffer = new BoundedBuffer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(buffer, "hello world !", "put");
			}
		}, "put").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(buffer, null, "take");
			}
		}, "take").start();
	}
	
	public static void threadExecute(BoundedBuffer buffer, Object data, String threadType) {
		for (int i = 0; i < 100000; i++) {
			try {
				if ("put".equals(threadType)) {
					buffer.put(data + String.valueOf(i));
				}else {
					buffer.take();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class BoundedBuffer{
	final Lock lock = new ReentrantLock();//锁对象
	final Condition notFull = lock.newCondition();//写线程条件
	final Condition notEmpty = lock.newCondition();//读线程条件
	
	final Object[] items = new Object[100]; //缓存队列
	int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;
	
	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {//如果队列满了
				notFull.await();//阻塞写线程
			}
			System.out.println(Thread.currentThread().getName() + "-->正在 写入数据：" + x);
			items[putptr] = x;//赋值
			if (++putptr == items.length) {//如果写索引写到队列的最后一个位置，那么置为0
				putptr = 0;
			}
			++count;//个数++
			notEmpty.signal(); //唤醒读线程
		} finally {
			lock.unlock();
		}
	}
	
	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {//如果队列为空
				notEmpty.await();//阻塞读线程
			}
			Object x = items[takeptr];//取值
			System.out.println(Thread.currentThread().getName() + "正在读取数据：" + x);
			if (++takeptr == items.length) {//如果读索引读到最后一个位置，那么置为0
				takeptr =0;
			}
			--count;//个数--
			notFull.signal();//唤醒写线程
			return x; 
		} finally {
			lock.unlock();
		}
	}
	
	
	
}
/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo08
 * 创建时间：2018年1月25日下午4:32:23
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo08;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：【读写锁】锁对象Lock-同步问题更完美的处理方式
 * 需求-->写入和写入互斥、读取和写入互斥、读取和读取不互斥。
 * 		在对数据进行读写的时候，为了保证数据的一致性和完整性，需要读和写是互斥的，但是读和读是不需要互斥 的，这样读和读不互斥性能会更高。
 * 			
 * @author songfayuan
 * 2018年1月25日下午4:32:23
 */
public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Data data = new Data();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.setData(new Random().nextInt(30));
					}
				}
			}, "write").start();
		}
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.getData();
					}
				}
			}, "read").start();
		}
	}
	
}

class Data{
	private int data;   //共享数据
	private ReadWriteLock lock = new ReentrantReadWriteLock();  //锁对象
	public void setData(int data) {
		lock.writeLock().lock();  //取到写锁
		try {
			System.out.println(Thread.currentThread().getName() + "准备写入数据");
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "写入" + this.data);
		} finally {
			lock.writeLock().unlock(); //释放写锁
		}
	}
	
	public void getData(){
		lock.readLock().lock(); //取到读锁
		try {
			System.out.println(Thread.currentThread().getName() + "准备读取数据");
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "读取" + this.data);
		} finally {
			lock.readLock().unlock();  //释放读锁
		}
	}
}

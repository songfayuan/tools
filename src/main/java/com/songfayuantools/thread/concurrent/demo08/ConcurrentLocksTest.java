/**
 * 项目名称：tools
 * 项目包名：concurrent
 * 创建时间：2018年1月23日上午10:41:54
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：Locak是java.util.concurrent.locks包下的接口，Lock实现提供了比使用synchronized方法和语句可获得更广泛的锁定操作。
 * 
 * 	         用sychronized修饰的方法或者语句块在代码执行完之后锁自动释放，而用Lock需要我们手动释放锁，所以为了保证锁最终被释放，要把互斥区放在try内，释放锁放在finally内。
 * @author songfayuan
 * 2018年1月23日上午10:41:54
 */
public class ConcurrentLocksTest {
	
	public static void main(String[] args) {
		final Outputter1 output = new Outputter1();
		new Thread(){
			public void run() {
				output.output("songfayuan");
			};
		}.start();
		new Thread(){
			public void run() {
				output.output("sunbin");
			};
		}.start();
	}	
	
}

class Outputter1{
	private Lock lock = new ReentrantLock(); //锁对象
	public void output(String name){
		//线程输出方法
		lock.lock(); //得到锁
		try {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
		} finally {
			lock.unlock(); //释放锁
		}
	}
}

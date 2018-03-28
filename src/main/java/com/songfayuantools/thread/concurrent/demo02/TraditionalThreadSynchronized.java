/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo02
 * 创建时间：2018年1月19日上午9:52:56
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo02;

/**
 * 描述：线程同步synchronized和volatile
 * 		使用synchronized修饰的方法或者代码块可以看成是一个原子操作。
 * 
 * 		缺点：使用synchronized在某些情况下会造成死锁
 * 
 * 		一个线程执行互斥代码过程如下：
 * 						1、获得同步锁
 * 						2、清空工作内存
 * 						3、从主内存拷贝对象副本到工作内存
 * 						4、执行代码（计算或者输出等）
 * 						5、释放同步锁
 * @author songfayuan
 * 2018年1月19日上午9:52:56
 */
public class TraditionalThreadSynchronized {
	
	public static void main(String[] args) {
		OutPutter outPutter = new OutPutter();
		
		new Thread(){
			public void run() {
				outPutter.outPut("songfayuan");
			}
		}.start();
		
		new Thread(){
			public void run() {
				outPutter.outPut("sunbin");
			}
		}.start();
		
		new Thread(){
			public void run() {
				outPutter.outPut2("zhangchenzhuo");
			}
		}.start();
		
		new Thread(){
			public void run() {
				outPutter.outPut2("yuzhongrui");
			}
		}.start();
	}	
	
}

class OutPutter{
	public void outPut(String name) {
		synchronized (this) {  //方法一：使用synchronized将需要互斥的代码包含起来，并上一把锁，这把锁必须是需要互斥的多个线程间的共享对象。
			//为保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void outPut2(String name) {  //方法二：将synchronized加在需要互斥的方法上，这种方式就相当于用this锁住整个方法内的代码块
		//为保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo04
 * 创建时间：2018年1月22日上午10:47:21
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo04;

/**
 * 描述：线程合并-->join() 所谓合并，就是等待其他线程执行完，再执行当前线程，执行起来的效果就好像把其他线程合并到当前线程执行一样。
 * @author songfayuan
 * 2018年1月22日上午10:47:21
 */
public class JoinTest {
	
	public static void main(String[] args) throws InterruptedException {
		JoinThread t1 = new JoinThread("t1");
		JoinThread t2 = new JoinThread("t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("主线程开始执行！");
	}	
	
}

class JoinThread extends Thread{
	public JoinThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "-->" + getId() + "执行了" + i + "次");
		}
	}
}
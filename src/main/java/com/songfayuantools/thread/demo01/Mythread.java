/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo01
 * 创建时间：2017年8月30日下午7:38:14
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.demo01;


/**
 * 描述：Java多线程【统计所有子进程执行完毕总共的耗时】--让主线程等待所有子线程执行完毕
 * @author songfayuan
 * 2017年8月30日下午7:38:14
 */
public class Mythread extends Thread {
	
	private CountDown count;
	
	public Mythread(CountDown count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始...");  //打印开始标记
		//do something...
		count.countDown(); //计时器减1
		System.out.println(Thread.currentThread().getName() + "结束...");  //打印结束标记
	}

	public static void main(String args[]) {
		Integer threadNum = 10;  //线程数量
		long startTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + "开始...");  //打印开始标记
		CountDown c = new CountDown(threadNum);  //初始化countDown
		for (int i = 0; i < threadNum; i++) {  //开threadNum个线程
			Thread t = new Mythread(c);
			t.start();
		}
		while (true) { //等待所有子线程执行完
			if (!c.hasNext()) {
				break;
			}
			try {
				//Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束...");  //打印结束标记
		long endTime = System.currentTimeMillis();
		System.out.println("总共用时：" + (endTime - startTime) + "millions");
	}
	
}

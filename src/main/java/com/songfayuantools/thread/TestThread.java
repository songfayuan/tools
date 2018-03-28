/**
 * 项目名称：dream_user
 * 项目包名：org.songbai.fore.news.controller
 * 创建时间：2017年8月30日上午9:15:55
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread;

/**
 * 描述：
 * @author songfayuan
 * 2017年8月30日上午9:15:55
 */
public class TestThread {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();    //获取开始时间
		Ticket ticket = new Ticket();
		Thread thread1 = new Thread(ticket, "A");
		Thread thread2 = new Thread(ticket, "B");
		Thread thread3 = new Thread(ticket, "C");
		Thread thread4 = new Thread(ticket, "D");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	}

}


class Ticket implements Runnable{

	private int Numbers = 100;

	public int getNumbers() {
		return Numbers;
	}

	public void setNumbers(int numbers) {
		Numbers = numbers;
	}
	
	
	@Override
	public void run() {
		while (getNumbers()>0) {
			synchronized (this) {
				if (getNumbers()>0) {
					System.out.println(Thread.currentThread().getName() + "卖了一张票：剩余余票数---" + getNumbers());
					Numbers--;
//					NewsController aa = new NewsController();
//					System.out.println(aa.findNewsByUrl("http://www.cisau.com.cn/"));
//					System.out.println(aa.findNewsByUrl("https://dev.etohui.com/user/yesterdayProfitReportController/findYesterdayProfitReportList.do"));
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
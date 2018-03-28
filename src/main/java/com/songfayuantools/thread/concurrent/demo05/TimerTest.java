/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo05
 * 创建时间：2018年1月22日下午2:23:43
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：   实现一个连环炸弹，2秒后爆炸一次，3秒后爆炸一次，如此循环下去。
 * 
 * 		Timer是一种线程设施，用于安排以后在后台线程中执行的任务。可以安排执行一次，或者定期重复执行，可以看成一个定时器，可以调度TimerTask。
 * 		TimerTask是一个抽象类，实现了Runnable接口，所以具备了多线程的能力。
 * 		schedule是Timer调度任务的方法，Timer重构了四个schedule方法。
 * @author songfayuan
 * 2018年1月22日下午2:23:43
 */
public class TimerTest {

	static class MyTimerTask1 extends TimerTask{
		@Override
		public void run() {
			System.out.println("爆炸！！！");
			new Timer().schedule(new MyTimerTask2(), 2000);//2秒后启动任务
		}
	}
	
	static class MyTimerTask2 extends TimerTask{
		@Override
		public void run() {
			System.out.println("爆炸！！！");
			new Timer().schedule(new MyTimerTask1(), 3000);//3秒后启动任务
		}
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask2(), 2000); //2秒后启动任务
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);  //睡眠1秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

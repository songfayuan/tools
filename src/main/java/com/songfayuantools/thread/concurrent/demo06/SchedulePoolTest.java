/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.concurrent.demo06
 * 创建时间：2018年1月22日下午6:14:43
 * 创建者：Administrator-宋发元
 * 创建地点：杭州
 */
package com.songfayuantools.thread.concurrent.demo06;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述：ScheduledThreadPool可以定时的或延时的执行任务
 * @author songfayuan
 * 2018年1月22日下午6:14:43
 */
public class SchedulePoolTest {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);
		//5秒后执行任务
		scheduledPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("爆炸！");
			}
		}, 5, TimeUnit.SECONDS);
		
		//5秒后执行任务，以后每2秒执行一次
		scheduledPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("爆炸了！！！！");
			}
		}, 5, 2, TimeUnit.SECONDS);
	}
	
}

/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.ThreadPool
 * 创建时间：2017年9月3日上午10:30:55
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述：newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * @author songfayuan
 * 2017年9月3日上午10:30:55
 */
public class ScheduledThreadPool {
	 public static void main(String[] args) {  
		  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
		  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
		   public void run() {  
		    System.out.println("delay 1 seconds, and excute every 3 seconds");  
		   }  
		  }, 1, 3, TimeUnit.SECONDS);  //表示延迟1秒后每3秒执行一次。
		 } 
}

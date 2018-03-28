/**
 * 项目名称：tools
 * 项目包名：com.songfayuantools.thread.demo01
 * 创建时间：2017年8月30日下午10:03:50
 * 创建者：Administrator-宋发元
 * 创建地点：杭州钜元网络科技有限公司
 */
package com.songfayuantools.thread.demo01;

/**
 * 描述：
 * @author songfayuan
 * 2017年8月30日下午10:03:50
 */
public class CountDown {

	private int count;
	
	public CountDown(int count) {
		this.count = count;
	}
	
	public synchronized void countDown() {
		count--;
	}
	
	public synchronized boolean hasNext() {
		return (count > 0);
	}
	
	public int getCount() {
		return count;
	}
	
	public void  setCount(int count) {
		this.count = count;
	}
	
}

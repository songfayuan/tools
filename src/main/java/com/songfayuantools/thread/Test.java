package com.songfayuantools.thread;

import com.songfayuantools.http.HttpTools;

public class Test implements Runnable {

	public static void main(String[] args) throws Exception {
		
		Integer i = 0;
		while (i<=10000) {
			i++;
			System.out.println("++++++++++++++++++++++++++++++++++++++i="+i);
			Test test = new Test();
			Thread thread = new Thread(test);
			thread.start();
			Thread.sleep(10);
		}
	}

	@Override
	public void run() {
		String url = "http://www.cisau.com.cn/";
		String news = HttpTools.doGet(url, null);
		System.out.println(news);
	}

}

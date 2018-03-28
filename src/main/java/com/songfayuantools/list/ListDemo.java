package com.songfayuantools.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListDemo {

	public static void main(String[] args) {
		Map<String, String> report = new HashMap<>();
		report.put("mt4UserId", "1"); 
		report.put("sellTime", "123456");
		report.put("totalProfit", "1688");
		Map<String, String> report2 = new HashMap<>();
		report2.put("mt4UserId", "2"); 
		report2.put("sellTime", "78787");
		report2.put("totalProfit", "78787");
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(report);
		list.add(report2);
	}

}

package com.songfayuantools.uuid;

import org.apache.tomcat.util.codec.binary.Base64;

public class demo {

	public static void main(String[] args) {
		String numFormat = Integer.toHexString(349374762 + 1688);
		char[] cs = numFormat.toCharArray();
		String result = "";
		for (int i = 0; i < cs.length; i++) {
			int c = cs[i];
			result += (char) (97 + (c + (i % 2 == 0 ? i * 2 : i + 3)) % 26);
			result += (char) (Math.random() * 26 + 97);
			result += (char) (Math.random() * 26 + 97);
		}
		result=Integer.toString((int)(Math.random()*36), 36)+Integer.toString((int)(Math.random()*36), 36)+result;
		result=result+Integer.toString((int)(Math.random()*36), 36)+Integer.toString((int)(Math.random()*36), 36);
//		Cookie token1 = new Cookie(TOKEN1, Base64.encodeBase64String(result.getBytes()));
		System.out.println(result);
		System.out.println(Base64.encodeBase64String(result.getBytes()));
	}

}

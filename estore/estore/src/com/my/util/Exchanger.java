package com.my.util;

import java.io.UnsupportedEncodingException;

public class Exchanger {
	// 一个判断获取字符串为非空对象的情况
	public static String panduanIsNull(String str) {
		String ss = null;
		if (str == null) {
			str = "";
			System.out.println("获取的为空对象");
		} else {
			ss = str; // 没有处理乱码
		}
		return ss;
	}

	// 将字符串获取转换为int类型
	public static int exchangerIntoInt(String str) {
		int i = 0;
		// str一定是非空对象，如果是空，0 非空转换
		str = panduanIsNull(str); // 即使是空也转换好了 “” str.
		try {
			if (str.equals("")) {
				i = 0;
			} else {
				i = Integer.parseInt(str); // "1"
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	// 将获取的字符串进行乱码处理，返回一个字符串
	public static String exchange(String str) {
//		String ss = "";
//		try {
//			if (str == null) {
//				ss = "";
//			} else {
//				ss = new String(str.getBytes("ISO-8859-1"), "UTF-8");
//			}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//
//			e.printStackTrace();
//		}
		return str;
	}

}

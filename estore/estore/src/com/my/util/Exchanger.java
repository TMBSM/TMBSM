package com.my.util;

import java.io.UnsupportedEncodingException;

public class Exchanger {
	// һ���жϻ�ȡ�ַ���Ϊ�ǿն�������
	public static String panduanIsNull(String str) {
		String ss = null;
		if (str == null) {
			str = "";
			System.out.println("��ȡ��Ϊ�ն���");
		} else {
			ss = str; // û�д�������
		}
		return ss;
	}

	// ���ַ�����ȡת��Ϊint����
	public static int exchangerIntoInt(String str) {
		int i = 0;
		// strһ���Ƿǿն�������ǿգ�0 �ǿ�ת��
		str = panduanIsNull(str); // ��ʹ�ǿ�Ҳת������ ���� str.
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

	// ����ȡ���ַ����������봦������һ���ַ���
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

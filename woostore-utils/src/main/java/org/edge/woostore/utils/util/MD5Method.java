package org.edge.woostore.utils.util;

import java.security.MessageDigest;

public class MD5Method {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// MD5_Test aa = new MD5_Test();
		String[] var = { "admin", "111111", "222222", "333333", "444444",
				"555555", "666666", "777777", "888888", "999999" };
		for (int i = 0; i < var.length; i++) {
			System.out.println(var[i] + " MD5�����ǣ�" + MD5Method.MD5(var[i]));
		}
	}
}

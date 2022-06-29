package com.neuedu.utils;
/**
 * 处理字符串
 * @author lance
 *
 */
public class HandleString {
	public static Object returnNullByString(String str) {
		if(str == null) {
			return null;
		}else if(str.isEmpty()){
			return null;
		}else {
			return str;
		}
	}
}

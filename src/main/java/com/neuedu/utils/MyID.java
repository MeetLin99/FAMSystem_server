package com.neuedu.utils;

import java.util.Date;
/**
 * 本类负责生成18位数字的ID号
 * @author 清水三千尺
 *
 */
public class MyID {
	public static String getID() {
		// 获取时间戳
		String millis = System.currentTimeMillis() + "";
		// 获取当前日期的年份后两位、月份后一位、日
		Date dt = new Date();
		String year = String.format("%tY", dt);
		year = year.substring(2);
		String mon = String.format("%tm", dt);
		mon = mon.substring(1);
		String day = String.format("%td", dt);
		return year + mon + day + millis;
	}
}

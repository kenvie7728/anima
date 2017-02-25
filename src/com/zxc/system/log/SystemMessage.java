package com.zxc.system.log;

import java.util.Calendar;

public class SystemMessage {

	// 获取系统时间
	public static String getSystemTime() {
		Calendar c = Calendar.getInstance();
		String time = "时间：" + c.get(Calendar.YEAR) + "年"
				+ (c.get(Calendar.MONTH) + 1) + "月"
				+ c.get(Calendar.DAY_OF_MONTH) + "日";
		time = time + "             " + c.get(Calendar.HOUR_OF_DAY) + "时"
				+ c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒";
		time=time+"                   ";
		return time;
	}
	
}

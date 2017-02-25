package com.zxc.system.log;

/*
 * 该类处理日记
 */
public class Log {
	
	//操作日记
	public static void addOptionLog(String type,String message){
 	       new LogWriter().writeLog(type,message);
 	}
	
	//错误日记
	public static void addErrorLog(String message){
	    System.out.println("Error:"+message);  
		new LogWriter().writeLog("Error",message);
	}
	
	
	//系统日记
	public static void addSystemLog(String message){
	       new LogWriter().writeLog("System",message);
	}
	
}

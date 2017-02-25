package com.zxc.tell.bean;

import java.util.HashMap;
import java.util.Map;

public class Tran {
     
	private static Map<String,String> map=new HashMap<String,String>();
    
	public static void addValue(String key,String value){
		map.put(key, value);
	}
	
	public static String getValue(String key){
		return map.get(key);
	}
      
}

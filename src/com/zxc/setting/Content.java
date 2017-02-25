package com.zxc.setting;

import java.util.Map;
import java.util.TreeMap;

public class Content {
 private static Map<String,String> map =new TreeMap<String,String>();
     
     public static void addValue(String key,String value){
    	map.put(key, value);
     }
     
     public static Map<String,String> getMap(){
    	 return map;
     }
}

package com.zxc.language;

import java.util.Map;
import java.util.TreeMap;

public class French {
	  private static Map<String,String> map =new TreeMap<String,String>();
	     
	     public static void addValue(String key,String value){
	    	 key=key.replace(" ","");
	    	key=key.toLowerCase();
	    	 map.put(key, value);
	    	 System.out.println(key+"="+value);
	    }
	     
	     public static Map<String,String> getMap(){
	    	 return map;
	     }
}

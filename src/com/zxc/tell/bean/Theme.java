package com.zxc.tell.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Theme {

	private static List<String> list = new LinkedList<String>();
	private static Map<String, String> map = new TreeMap<String, String>();

	public static void addValue(String key, String value) {
		list.add(key);
		map.put(key, value);
	}
	
	public static String getValue(String problem){
		for(String str:list){
			if(str.indexOf(problem)!=-1)return map.get(str);
		}
		return null;
	}
}

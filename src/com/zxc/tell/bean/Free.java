package com.zxc.tell.bean;

import java.util.ArrayList;
import java.util.List;

public class Free {

	private static List<String> list =new ArrayList<String>();
    
	public static void addValue(String value){
		list.add(value);
	}
	
	public static String getValue(){
		int n =list.size();
		int num=(int)(Math.random()*n);
		return list.get(num);
	}
}

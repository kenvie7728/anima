package com.zxc.pet.bean;

import java.util.ArrayList;
import java.util.List;

public class FindList {
        
	 private static List<String> list =new ArrayList<String>();
	 
	 public static void addValue(String value){
		 list.add(value);
	 }
	 
	 public static String getValue(int index){
		 return list.get(index);
	 }
	 
	 public static void clear(){
		 if(list.size()!=0)
		 list.clear();
	 }
}

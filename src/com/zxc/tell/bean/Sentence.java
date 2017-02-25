package com.zxc.tell.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sentence {
       
	   private static Map<String,String> map =new TreeMap<String,String>();
	   private static Map<String,String> map2 =new TreeMap<String,String>();
	   
	   private static List<String> list=new LinkedList<String>();
	   private static List<String> list2=new LinkedList<String>();
	   
	   public static void addMap(String key,String value){
		   map.put(key, value);
		   list.add(key);
	   }
	   
	   public static Map<String,String> getMap(){
		   return map;
	   }
	   
	   public static void addMap2(String key,String value){
		   map2.put(key, value);
		   list2.add(key);
	   }
	   
	   public static Map<String,String> getMap2(){
		   return map2;
	   }
	   
	   public static List<String> getList(){
		   return list;
	   }
	   
	   public static List<String> getList2(){
		   return list2;
	   }
	   
	   public static void remove(String key){
		   map.remove(key);
	   }
	   
}

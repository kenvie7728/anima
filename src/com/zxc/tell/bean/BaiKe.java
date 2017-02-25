package com.zxc.tell.bean;

import java.util.Map;
import java.util.TreeMap;

public class BaiKe {
      private static Map<String,String> tree = new TreeMap<String,String>();
      
      public static void add(String key,String value){
    	  tree.put(key, value);
      }
      
      public static Map getTree(){
    	  return tree;
      }
}

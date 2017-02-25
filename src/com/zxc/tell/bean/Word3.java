package com.zxc.tell.bean;

import java.util.LinkedList;
import java.util.List;

public class Word3 {
      private static List<String> list =new LinkedList<String>();
      
      public static void add(String value){
    	  list.add(value);
      }
      
      public static List<String> getList(){
    	  return list;
      }
      
}

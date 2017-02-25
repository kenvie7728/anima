package com.zxc.communication.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserList {
   private static List<com.zxc.communication.bean.User> list=new LinkedList<com.zxc.communication.bean.User>();
   
   //添加用户类
   public static void addUser(com.zxc.communication.bean.User user){
	list.add(user);   
   }
   
   //获取用户类列表
   public static List<com.zxc.communication.bean.User> getUserList(){
	   return list;
   }
   
   //删除用户类
   public static void deleteUser(int index){
	   list.remove(index);
   }
   
   //排序
   public static void sort(){
	   Collections.sort(list);
   }
}

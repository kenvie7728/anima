package com.zxc.communication.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Reader{
       public void run(){
    	   try{
    		   InputStreamReader in=new InputStreamReader(new FileInputStream("./dat/user.dat"),"UTF-8");
    	       BufferedReader bu=new BufferedReader(in);
    	       while(bu.ready()){
    	    	   com.zxc.communication.bean.User user=new com.zxc.communication.bean.User();
    	    	   user.setName(bu.readLine());
    	    	   user.setPhone(bu.readLine());
    	    	   user.setTel(bu.readLine());
    	           user.setQq(bu.readLine());
    	           user.setEmail(bu.readLine());
    	           com.zxc.communication.bean.UserList.addUser(user);
    	       }
    	       bu.close();
    	       in.close();
    	   }catch(Exception error){
    		   com.zxc.system.log.Log.addErrorLog(error.getLocalizedMessage());
    	   }
       }
}

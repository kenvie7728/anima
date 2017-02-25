package com.zxc.tell.dao;

import java.io.File;

public class Tools {
      
	public String getFiles(String rude){
    	   StringBuffer s=new StringBuffer();
    	   File fp =new File(rude);
    	   if(!fp.exists()){
    		return "文件不存在～";   
    	   }else{
    		   File[] f =fp.listFiles();
    		   for(File te:f){
    			   s.append(te.getName()+"  ");
    		   }
    	   }
    	   
    	   return s.toString();
    }
	
	
}

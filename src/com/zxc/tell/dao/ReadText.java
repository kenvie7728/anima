package com.zxc.tell.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadText {
       
	public String getText(String rude){
    StringBuffer s=new StringBuffer();
    if(!new File(rude).exists())return null;
    
    try{
    	InputStreamReader in =new InputStreamReader(new FileInputStream(rude),"UTF-8"); 
        BufferedReader bu =new BufferedReader(in);
        while(bu.ready()){
        	s.append(bu.readLine()+'\r'+'\n');
        }
        bu.close();
        in.close();
        
    }catch(Exception error){
    	return "error:"+error.getMessage();
    }
    
    return s.toString();
    }
}

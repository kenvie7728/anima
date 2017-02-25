package com.zxc.system.log;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/*
 * 该类用于把日记写进文件
 */
public class LogWriter {
    private String rude = null;   
	private String message=null;
    
	public void writeLog(String rude,String message){
    	   this.rude=rude;
    	   this.message=message;
    	   new t().start();
    }
    
    private class t extends Thread{
    	public void run(){
    		   try{
    			   OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./log/"+rude+".dat",true),"UTF-8");
    		       BufferedWriter bu =new BufferedWriter(out);
    		       bu.write(SystemMessage.getSystemTime()+message+'\r'+'\n');
    		       bu.close();
    		       out.close();
    		   }catch(Exception error){
    			   
    		   }
    	}
    }
    
}

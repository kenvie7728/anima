package com.zxc.tell.dao;

import java.io.File;
import java.util.Calendar;

public class Control {
       
	public String startControl(String order,com.zxc.tell.ui.Ui ui){
    	  String result=null;
    	  
    	  if(order.equals("#time")){
    		  //显示时间
    		  Calendar c=Calendar.getInstance();
    	      result="时间："+c.get(Calendar.HOUR_OF_DAY)+"时"+c.get(Calendar.MINUTE)+"分"+c.get(Calendar.SECOND)+"秒";
    	  }else if(order.equals("#date")){
    		//显示日期
    		  Calendar c=Calendar.getInstance();
    	      result="日期："+c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日";
    	  }else if(order.equals("#cal")){
    		//显示日期和时间
    		  Calendar c=Calendar.getInstance();
    		  result="日期："+c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日";
    		  result=result+"        "+"时间："+c.get(Calendar.HOUR_OF_DAY)+"时"+c.get(Calendar.MINUTE)+"分"+c.get(Calendar.SECOND)+"秒";
    	  }else if(order.equals("#status")){
    		  
    	  }else if(order.equals("#exit")){
    		  ui.exit();
    		  result="#exit";
    	  }else if(order.equals("#help")){
    		  result = new ReadText().getText("./data/tell/help.sh");
    	  }else if(order.startsWith("#ls")){
    		  if(order.equals("#ls")){
    			  result = new Tools().getFiles(".");
    		  }else{
    			  String[] te = order.split(" ");
    			  if(te.length!=2)return "命令出错～";
    			  result = new Tools().getFiles(te[1]);
    		  }
    	  }else if(order.startsWith("#cat")){
    		  String[] te=order.split(" ");
    		  if(te.length!=2){
    			  return "命令出错～";
    		  }else{
    			  File fp =new File(te[1]);
    			  if(!fp.exists())return "文件不存在～";
    			  if(fp.isDirectory())return "该文件不可读～";
    			  result=new ReadText().getText(te[1]);
    		  }
    	  }
    	  
    	  
    	  return result;
    }
	
}

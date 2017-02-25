package com.zxc.filefinder;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FileFinder extends Thread{
      private boolean end =false;
      private String rude = null;
     private DefaultListModel<String> m =null;
     private JLabel label;
     private String fileName=null;
     private JButton button=null;
     
     public void exit(){
    	 end=true;
     }
     
      public FileFinder(String rude,DefaultListModel<String> m,JLabel label,String name,JButton button){
    	  this.rude=rude;
    	  this.m=m;
    	  this.label=label;
    	  this.fileName=name;
    	  this.button=button;
      }
      
      public void run(){
    	 find(new File(rude),m,label);
           label.setText("查找结束～");
           button.setText(com.zxc.language.Manager.getValue("tool_finder_find"));
      }
      
      private File[] find(File fp,DefaultListModel<String> m,JLabel label){
    	  try{
    		  if(end)return null;
    		  File[] fpList=fp.listFiles();
    		  for(File te:fpList){
    			  label.setText("正在查找："+te.getCanonicalPath());
    			  if(te.isDirectory())find(te,m,label);
    			  else {
    				  if(te.getName().indexOf(fileName)!=-1)
    				  m.add(m.getSize(),te.getCanonicalPath());
    			  }
    			  }
    	  }catch(Exception error){
    		  
    	  }
    	  return null;
      }
}

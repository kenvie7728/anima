package com.zxc.pet.dao;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ShowPic extends Thread{

	private boolean stop=false;
	private boolean end=false;
	private com.zxc.pet.ui.PetUi ui=null;
	private List<String> list =new LinkedList<String>(); 
	private List<String> list2 =new LinkedList<String>(); 
	private int num=0;
	
	public ShowPic(){
		try{
			File fp=new File("./data/pic");
			File[] f=fp.listFiles();
			for(File f1:f){
				if(f1.isFile()){
					list.add(f1.getAbsolutePath());
					list2.add(f1.getName());
				}
			}
		}catch(Exception error){
			
		}
	}
	
    public ShowPic(com.zxc.pet.ui.PetUi ui){
		this();
    	this.ui=ui;
	}
	
	public void stopThread(){
		stop=true;
	}
	
	public void startThread(){
		stop=false;
	}
	
	public void exit(){
		end=true;
	}
	
	public void run(){
		try{
			while(!end){
				if(!stop){
				
					num++;
					if(num>=list.size())num=0;
			    ui.setImage(list.get(num),list2.get(num).substring(0,list2.get(num).length()-4));
				
				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
			}
		}catch(Exception error){
			
		}
	}
	
}

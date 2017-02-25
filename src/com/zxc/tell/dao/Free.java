package com.zxc.tell.dao;


public class Free extends Thread{
       
	private com.zxc.tell.ui.Ui u;
	private int i=0;
	private boolean b=true;
	
	public Free(){
    	   super();
    }
	
	public Free(com.zxc.tell.ui.Ui u){
		this();
		this.u=u;
	}
	
	public void exit(){
		b=false;
	}
	
	public void set(){
		i=0;
	}
	
	@Override
	public void run(){
		while(b){
			try{
				if(i==30){
				u.addText(""+'\n'+"root:"+com.zxc.tell.bean.Free.getValue());
					i=0;
				}
				i++;
				Thread.sleep(1000);
			}catch(Exception error){
				
			}
			
		}
	}
	
}

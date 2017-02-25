package com.zxc.car.ui;

import javax.swing.JLabel;

public class RobotThread extends Thread{
    
	private JLabel label=null;
	private boolean end=false;
	private boolean stop=false;
	
	public void exit(){
		end=true;
	}
	
	public void setStop(boolean stop){
		this.stop=stop;
	}
	
	public RobotThread(JLabel label){
		super();
		this.label=label;
		this.setLocation();
	}
	
	private void setLocation(){
		int x =(int)(Math.random()*650);
		label.setLocation(x,-70);
	}
	
	public void run(){
		while(!end){
			try{
				if(!stop){
				if(label.getLocation().y>=420)
					this.setLocation();
					label.setLocation(label.getLocation().x,label.getLocation().y+20);
				}
				Thread.sleep(500);
			}catch(Exception error){
				
			}
		}
	}
	
}

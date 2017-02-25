package com.zxc.tool;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class Pane {
       
	protected JFrame frame;
    protected JButton button1,button2,button3,button4,button5,button6;
    
    public Pane(){
    	
    }
    
    //创建窗口
    public void createWindow(){
    	this.addJFrame();
    	this.addButton();
    	this.addListener();
    	frame.setVisible(true);
    }
    
    private void addJFrame(){
    	frame=new JFrame();
    	frame.setSize(500,300);
    	frame.setResizable(false);
    	frame.setTitle("manager");
    	frame.setLayout(null);
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	
    	
    }
    
    private void addButton(){
    	button1 =new JButton("a");
    	button2 = new JButton("b");
    	button3 = new JButton("c");
    	button4 = new JButton("d");
    	button5 = new JButton("e");
    	button6 = new JButton("f");
    	
    	button1.setBounds(20,50,170,20);
    	button2.setBounds(300,50,170,20);
    	button3.setBounds(20,150,170,20);
    	button4.setBounds(300,150,170,20);
    	button5.setBounds(20,230,170,20);
    	button6.setBounds(300,230,170,20);
    	
    	frame.add(button1);
    	frame.add(button2);
    	frame.add(button3);
    	frame.add(button4);
    	frame.add(button5);
    	frame.add(button6);
    }
    
    protected abstract void addListener();
    
}

package com.zxc.system.log;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;


public class Ui {

	private JFrame frame;
	private JList<String> list;
	private DefaultListModel<String> m;
	
	public Ui(){
		
	}
	
	public void createWindow(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setTitle(com.zxc.language.Manager.getValue("log"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/log/u1.png"));
		
        m=new DefaultListModel<String>();
        list=new JList<String>(m);
        list.setBounds(20,20,460,250);
        new T().start();
		frame.add(list);
		frame.setVisible(true);
		
	}
	
	private class T extends Thread{
		
		public void run(){
			try{
				System.out.println("g");
				InputStreamReader in=new InputStreamReader(new FileInputStream("./log/Error.dat"),"UTF-8");
			    BufferedReader bu=new BufferedReader(in);
			    while(bu.ready()){
			  	m.add(m.getSize(),bu.readLine());
			    }
			    bu.close();
			    in.close();
			}catch(Exception error){
				System.out.println(error.getMessage());
			}
		}
		
	}
	
}

package com.zxc.system.log;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Window {

	public void showOptionLog(String rude) {
		JFrame frame = new JFrame();
		DefaultListModel<String> m=new DefaultListModel<String>();
		JList<String> list=new JList<String>(m);
		JScrollPane s=new JScrollPane(list);
		s.setBounds(10,10,470,220);
		
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		frame = new JFrame();
		frame.setBounds((width - 500) / 2, (height - 300) / 2, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("日记");
		frame.setLayout(null);
		frame.add(s);
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./log/"+rude+".dat"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	m.add(m.getSize(),bu.readLine());
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		frame.setVisible(true);
	}
}

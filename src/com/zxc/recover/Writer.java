package com.zxc.recover;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Writer {
      
	private JFrame frame;
	private JProgressBar p;
	private JLabel l;
	
	private String rude1,rude2;
	
	public void copy(String rude1,String rude2,String title){
		this.rude1=rude1;
		this.rude2=rude2;
		
		frame=new JFrame();
	    frame.setSize(300,100);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle(title);
	    frame.setLayout(null);
	    
	    p=new JProgressBar();
	    p.setBounds(20,20,260,20);
	    frame.add(p);
	    
	    l=new JLabel("0%");
	    l.setBounds(20,40,260,20);
	    frame.add(l);
	    
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    new T().start();
    }
	
	private class T extends Thread{
		
		@Override
		public void run(){
			try{
				long total=new File(rude1).length();
				long now=0;
				FileInputStream in =new FileInputStream(rude1);
				FileOutputStream out=new FileOutputStream(rude2);
			    int i;
			    while((i=in.read())!=-1){
			    	out.write(i);
			    	now++;
			    	int pro=(int)(now*100/total);
			    	l.setText(pro+"%");
			    	p.setValue(pro);
			    }
				in.close();
			    out.close();
			    JOptionPane.showMessageDialog(null, "操作成功！");
			   frame.dispose();
			}catch(Exception error){
				
			}
		}
		
	}
	
}

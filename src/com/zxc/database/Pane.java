package com.zxc.database;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public abstract class Pane {
      
	protected JFrame frame;
	protected JCheckBox c1,c2,c3;
	protected ButtonGroup g;
	protected JButton button1,button2,button3;
	protected JProgressBar p;
	protected JLabel l;
	
	public Pane(){
		frame = new JFrame();
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("in");
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		this.addCheckBox();
		this.addbutton();
		this.addProgressBar();
    }
	
	private void addCheckBox(){
		g=new ButtonGroup();
		c1=new JCheckBox(com.zxc.language.Manager.getValue("pane_c1"));
		c2=new JCheckBox(com.zxc.language.Manager.getValue("pane_c2"));
		c3=new JCheckBox(com.zxc.language.Manager.getValue("pane_c3"));
		
		c1.setBounds(20,20,170,20);
		c2.setBounds(20,50,170,20);
		c3.setBounds(20,80,170,20);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
	}
	
	private void addbutton(){
		button1=new JButton(com.zxc.language.Manager.getValue("pane_b1"));
		button2=new JButton(com.zxc.language.Manager.getValue("pane_b2"));
		button3=new JButton(com.zxc.language.Manager.getValue("pane_b3"));
		
		button1.setBounds(50,200,70,20);
		button2.setBounds(230,200,70,20);
		button3.setBounds(390,200,70,20);
		
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		
		button3.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						exit();
					}
				});
	}
	
	private void addProgressBar(){
		p=new JProgressBar();
		p.setBounds(20,120,440,20);
		p.setVisible(false);
		l=new JLabel("0%");
		l.setBounds(20,150,440,20);
		l.setVisible(false);
		frame.add(p);
		frame.add(l);
	}
	
	private void exit(){
		frame.dispose();
	}
	
	public abstract void showWindow();
	
}

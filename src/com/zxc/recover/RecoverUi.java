package com.zxc.recover;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class RecoverUi {
      
	private JFrame frame;
	private JButton button1,button2;
	
	public RecoverUi(){
		
	}
	
	public void showWindow(){
		frame=new JFrame();
	       frame.setSize(500,300);
	       frame.setResizable(false);
	       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	       frame.setTitle(com.zxc.language.Manager.getValue("recover_title"));
	       frame.setLayout(null);
	       frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
					"./pic/reset/u1.png"));
	       
	       this.addButton();
	       
	       frame.setLocationRelativeTo(null);
	       frame.setVisible(true);
	}
	
	private void addButton(){
		button1 =new JButton(com.zxc.language.Manager.getValue("recover_b1"));
		button2 = new JButton(com.zxc.language.Manager.getValue("recover_b2"));
		button1.setBounds(30,30,200,200);
		button2.setBounds(270,30,200,200);
		frame.add(button1);
		frame.add(button2);
		
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						JFileChooser c=new JFileChooser();
						if(c.showSaveDialog(null)==0){
							new Writer().copy("./setting/main", c.getSelectedFile().getAbsolutePath(), com.zxc.language.Manager.getValue("recover_message"));
						}
					}
				});
		
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						JFileChooser c=new JFileChooser();
						if(c.showOpenDialog(null)==0){
							new Writer().copy(c.getSelectedFile().getAbsolutePath(), "./setting/main",com.zxc.language.Manager.getValue("recover_message2"));
						}
					}
				});
		
	}
	
}

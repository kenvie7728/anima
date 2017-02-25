package com.zxc.setting;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ui {

	private int type;
	private JFrame frame;
	private ButtonGroup g;
	private JCheckBox b1, b2, b3, b4, b5, b6;
	private JButton button1, button2, a1, a2, a3;
	private JLabel label1, label2, label3;
	private JFileChooser c;
private com.zxc.pet.ui.PetUi u;
	private String r1, r2, r3;

	public Ui() {
		type=Integer.parseInt(com.zxc.setting.Content.getMap().get("language"));
		r1=com.zxc.setting.Content.getMap().get("pic_rude");
		r2=com.zxc.setting.Content.getMap().get("music_rude");
		r3=com.zxc.setting.Content.getMap().get("video_rude");
	}

	public Ui(int type,com.zxc.pet.ui.PetUi u) {
		this();
		this.type = type;
		this.u=u;
	}

	public void createWindow() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(com.zxc.language.Manager.getValue("setting_title"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/setting/u1.png"));
		this.addCheck();
		this.addButton();
		this.addLabel();
		frame.setVisible(true);
	}

	private void addCheck() {
		
		b1 = new JCheckBox("中文", true);
		b2 = new JCheckBox("English", false);
		b3 = new JCheckBox("日本语", false);
		b4 = new JCheckBox("韩语", true);
		b5 = new JCheckBox("俄语", false);
		b6 = new JCheckBox("法语", false);
		
		g = new ButtonGroup();
		g.add(b1);
		g.add(b2);
		g.add(b3);
		g.add(b4);
		g.add(b5);
		g.add(b6);
		
		b1.setBounds(20, 20, 170, 20);
		b2.setBounds(220, 20, 170, 20);
		b3.setBounds(420, 20, 170, 20);
		b4.setBounds(20, 50, 170, 20);
		b5.setBounds(220, 50, 170, 20);
		b6.setBounds(420, 50, 170, 20);
		
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		
		if (type == 1)
			b2.setSelected(true);
		else if (type == 2)
			b3.setSelected(true);
		else if (type == 3)
			b4.setSelected(true);
		else if (type == 4)
			b5.setSelected(true);
		else if (type == 5)
			b6.setSelected(true);
	}

	private void addButton() {
		
		button1 = new JButton(com.zxc.language.Manager.getValue("setting_ok"));
		button2 = new JButton(com.zxc.language.Manager.getValue("setting_canel"));
		button1.setBounds(50, 230, 170, 20);
		button2.setBounds(250, 230, 170, 20);
		
		frame.add(button1);
		frame.add(button2);
		
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						save();
					}
				});
		
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						exit();
					}
				});
	}

	private void save(){
		if(b1.isSelected())type=0;
		else if(b2.isSelected())type=1;
		else if(b3.isSelected())type=2;
		else if(b4.isSelected())type=3;
		else if(b5.isSelected())type=4;
		else type=5;
		com.zxc.setting.Content.getMap().clear();
		com.zxc.setting.Content.addValue("language",""+type);
		com.zxc.setting.Content.addValue("pic_rude",r1);
		com.zxc.setting.Content.addValue("music_rude",r2);
		com.zxc.setting.Content.addValue("video_rude",r3);
	    com.zxc.language.Manager.setType(Integer.parseInt(com.zxc.setting.Content.getMap().get("language")));
		
	    try{
	    	OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("./setting/main",false),"UTF-8");
	    	BufferedWriter bu =new BufferedWriter(out);
	    	bu.write("language="+com.zxc.setting.Content.getMap().get("language")+'\r'+'\n');
	    	bu.write("pic_rude="+com.zxc.setting.Content.getMap().get("pic_rude")+'\r'+'\n');
	    	bu.write("music_rude="+com.zxc.setting.Content.getMap().get("music_rude")+'\r'+'\n');
	    	bu.write("video_rude="+com.zxc.setting.Content.getMap().get("video_rude"));
	    	bu.close();
	    	out.close();
	    	JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("setting_message1"));
	    	u.setLanguage();
	    	this.exit();
	    }catch(Exception error){
	    	JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("setting_message2"));
	    }
		
	}
	
	private void addLabel() {
		
		label1 = new JLabel("pic :"+r1);
		label2 = new JLabel("music :"+r2);
		label3 = new JLabel("video :"+r3);
		label1.setBounds(20, 100, 300, 20);
		label2.setBounds(20, 130, 300, 20);
		label3.setBounds(20, 160, 300, 20);
		
		a1 = new JButton(com.zxc.language.Manager.getValue("setting_open"));
		a2 = new JButton(com.zxc.language.Manager.getValue("setting_open"));
		a3 = new JButton(com.zxc.language.Manager.getValue("setting_open"));
		a1.setBounds(380, 100, 100, 20);
		a2.setBounds(380, 130, 100, 20);
		a3.setBounds(380, 160, 100, 20);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(a1);
		frame.add(a2);
		frame.add(a3);
		
		a1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = c.showSaveDialog(null);
				if (i == 0) {
					r1 = c.getSelectedFile().getAbsolutePath();
					label1.setText("pic :"
							+ c.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		a2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = c.showSaveDialog(null);
				if (i == 0) {
					r2 = c.getSelectedFile().getAbsolutePath();
					label1.setText("pic :"
							+ c.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		a3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = c.showSaveDialog(null);
				if (i == 0) {
					r3 = c.getSelectedFile().getAbsolutePath();
					label1.setText("pic :"
							+ c.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
	}
	
	private void exit(){
		frame.dispose();
	}

}

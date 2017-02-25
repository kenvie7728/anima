package com.zxc.note.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UpdateMessageBox extends MessageBox{

	private com.zxc.note.bean.Note note;
	
	public UpdateMessageBox(){
		super();
		this.setTitle(com.zxc.language.Manager.getValue("tool_note_update_title"));
		addButton();
	}
	
	public void createWindow(Ui u,com.zxc.note.bean.Note note){
		this.createWindow(u);
		this.note=note;
		this.text1.setText(note.getContent());
		this.text2.setText(note.getGoalTime());
		this.text3.setText(note.getTitle());
		this.c.setSelected(note.isRemind());
	}
	
	@Override
	public void addButton() {
		JButton button1 = new JButton(com.zxc.language.Manager.getValue("tool_note_update_button1"));
		button1.setBounds(150,240,70,20);
		this.add(button1);
		
		JButton button2 = new JButton(com.zxc.language.Manager.getValue("tool_note_update_button2"));
		button2.setBounds(350,240,70,20);
		this.add(button2);
		
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						update();
					}
				});
		
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						exit();
					}
				});		
	}
	
	private void update(){
		note.setContent(text1.getText());
		note.setGoalTime(text2.getText());
		note.setTitle(text3.getText());
		note.setRemind(c.isSelected());
		note.setWriteTime(getDate()+"    "+getTime());
		u.refresh();
	    JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("tool_note_update_message"));
		exit();
	}
	
	private String getTime() {
		String time = "时间：";
		Calendar c = Calendar.getInstance();
		time = time + c.get(Calendar.HOUR_OF_DAY) + "时"
				+ c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒";
		return time;
	}

	private String getDate() {
		String date = "日期：";
		Calendar c = Calendar.getInstance();
		date = date + c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1)
				+ "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
		return date;
	}
	
	private void exit(){
		this.dispose();
	}
}

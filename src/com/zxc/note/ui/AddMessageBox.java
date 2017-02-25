package com.zxc.note.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.zxc.note.bean.Note;

public class AddMessageBox extends MessageBox{

	public AddMessageBox(){
		super();
		this.setTitle(com.zxc.language.Manager.getValue("tool_note_add_title"));
		addButton();
	}
	
	@Override
	public void addButton() {
		   JButton button1 =new JButton(com.zxc.language.Manager.getValue("tool_note_add_button1"));
		   JButton button2 =new JButton(com.zxc.language.Manager.getValue("tool_note_add_button2"));
	       button1.setBounds(50,235,70,20);
	       button2.setBounds(350,235,70,20);
	       this.add(button1);
	       this.add(button2);
	       
	       button1.addMouseListener(
	    		   new MouseAdapter(){
	    			   public void mouseClicked(MouseEvent event){
	    				   addNote();
	    			   }
	    		   });
	       
	       button2.addMouseListener(
	    		   new MouseAdapter(){
	    			 public void mouseClicked(MouseEvent event){
	    				 exit();
	    			 }
	    		   });
	}
	
	private void exit(){
		this.dispose();
	}

	private void addNote(){
		com.zxc.note.bean.Note note =new com.zxc.note.bean.Note();
		note.setContent(text1.getText());
		note.setGoalTime(text2.getText());
		note.setTitle(text3.getText());
		note.setRemind(c.isSelected());
		note.setWriteTime(getDate()+"    "+getTime());
		com.zxc.note.bean.NoteList.addNote(note);
		new com.zxc.note.dao.Writer().write(note);
		JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("tool_note_add_message"));
		u.refresh();
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
	
}

package com.zxc.note.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class LookMessageBox extends MessageBox{

	public LookMessageBox(){
		super();
		this.setTitle(com.zxc.language.Manager.getValue("tool_note_show_title"));
		addButton();
	}
	
	public void createWindow(Ui u,com.zxc.note.bean.Note note){
		this.createWindow(u);
		this.text1.setText(note.getContent());
		this.text2.setText(note.getGoalTime());
		this.text3.setText(note.getTitle());
		this.c.setSelected(note.isRemind());
		super.setEdit(false);
	}
	
	@Override
	public void addButton() {
		JButton button = new JButton(com.zxc.language.Manager.getValue("tool_note_show_exit"));
		button.setBounds(220,240,70,20);
		this.add(button);
		
		button.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						exit();
					}
				});
	}
	
	private void exit(){
		this.dispose();
	}
        
}

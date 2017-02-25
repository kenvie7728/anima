package com.zxc.tool;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolsPane extends Pane{
	
	public ToolsPane(){
		
	}
	
	protected void addListener(){
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/ui1.png"));
		this.frame.setTitle(com.zxc.language.Manager.getValue("tool_title"));
		this.button1.setText(com.zxc.language.Manager.getValue("tool_communication"));
		this.button2.setText(com.zxc.language.Manager.getValue("tool_note"));
		this.button3.setText(com.zxc.language.Manager.getValue("tool_finder"));
		this.button4.setText(com.zxc.language.Manager.getValue("tool_media"));
		this.button5.setText(com.zxc.language.Manager.getValue("tool_pic"));
		this.button6.setText(com.zxc.language.Manager.getValue("tool_shutdown"));
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.communication.ui.UiManager().createWindow();
					}
				});
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.note.ui.Ui().createWindow();
					}
				});
		
		
		
		button3.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.filefinder.Ui().createWindow();
					}
				});
		
		button4.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						try {
							String[] s=new String[2];
							s[0]="./avi/avi.exe";
							s[1]=com.zxc.setting.Content.getMap().get("pic_rude");
							Runtime rt = Runtime.getRuntime();
							Process p = rt.exec(s);
							
						} catch (Exception error) {

						}
					}
				});
		
		button5.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						try {
							String[] s=new String[2];
							s[0]="./photo/pic.exe";
							s[1]=com.zxc.setting.Content.getMap().get("pic_rude");
							Runtime rt = Runtime.getRuntime();
							Process p = rt.exec(s);
						} catch (Exception error) {

						}
					}
				});
		
		button6.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						try{
							Runtime rt = Runtime.getRuntime();
							Process p =rt.exec("./tool/shutdown.exe");
							}catch(Exception error){
								
							}
					}
				});
    }
}

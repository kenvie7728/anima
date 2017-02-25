package com.zxc.tool;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePane extends Pane{
      
	protected void addListener(){
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/ui2.png"));
		this.frame.setTitle(com.zxc.language.Manager.getValue("game_title"));
		this.button1.setText(com.zxc.language.Manager.getValue("game_chess"));
		this.button2.setText(com.zxc.language.Manager.getValue("game_fright"));
		this.button3.setText(com.zxc.language.Manager.getValue("game_get"));
		this.button4.setVisible(false);
		this.button5.setVisible(false);
		this.button6.setVisible(false);
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.chess.ui.Ui().createWindow();
					}
				});
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.fight.ui.Ui().createWindow();
					}
				});
		button3.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.car.ui.Ui().createWindow();
					}
				});
    }
}

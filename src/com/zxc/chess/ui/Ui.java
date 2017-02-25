package com.zxc.chess.ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ui {
	//
	private JFrame frame;
	private JLabel[] label;
	private com.zxc.chess.bean.Data data;
	private JLabel label1;
	private JButton button1,button2;
	private int people;
	private boolean end;

	public Ui() {
		data = new com.zxc.chess.bean.Data();
		people = 1;
		end = false;
	}

	public void createWindow() {
		this.startControl();
	}

	private void startControl() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/chess.png"));
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setTitle(com.zxc.language.Manager.getValue("game_chess_title"));
		frame.setLocationRelativeTo(null);

		label1 = new JLabel(com.zxc.language.Manager.getValue("game_chess_who1"));
		label1.setBounds(20, 500, 170, 20);
		frame.add(label1);

		button1 =new JButton(com.zxc.language.Manager.getValue("game_chess_b1"));
		button1.setBounds(50,530,170,20);
		button1.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						regret();
					}
				});
		
		button2 =new JButton(com.zxc.language.Manager.getValue("game_chess_b2"));
		button2.setBounds(550,530,170,20);
		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						refresh();
					}
				});
		
		frame.add(button1);
		frame.add(button2);
		
		this.addLabel();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	private void addLabel() {
		label = new JLabel[81];
		int x = 20, y = 10;
		int i = 1, j = 1, n = 1;
		while (i <= 8) {
			j = 1;
			x = 20;
			while (j <= 10) {
				label[n] = new JLabel();
				label[n].setBounds(x, y, 50, 50);
				try {
					label[n].setIcon(new ImageIcon("./pic/chess/0.jpg"));
				} catch (Exception error) {

				}
				label[n].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent event) {
						done(event);
					}
				});
				frame.add(label[n]);
				x = x + 75;
				j++;
				n++;

			}
			y = y + 60;
			i++;
		}
	}

	private void done(MouseEvent event) {
		if (!end) {
			int x = (event.getXOnScreen() - frame.getLocation().x - 20) / 75;
			int y = (event.getYOnScreen() - frame.getLocation().y - 30) / 60;
			int n = y * 10 + x + 1;

			boolean success = data.done(n);

			if (success) {
				if (people == 1) {
					ImageIcon image=new ImageIcon("./pic/chess/1.png");
					 image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
					label[n].setIcon(image);
					label1.setText(com.zxc.language.Manager.getValue("game_chess_who2"));
				} else {
					ImageIcon image=new ImageIcon("./pic/chess/2.png");
					 image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
					label[n].setIcon(image);
					label1.setText(com.zxc.language.Manager.getValue("game_chess_who1"));
				}
				int type = data.Win(n, people);

				if (type == 1) {
					end = true;
					label1.setText(com.zxc.language.Manager.getValue("game_chess_m1"));
					JOptionPane.showMessageDialog(null, "甲赢了");
				} else if (type == 2) {
					end = true;
					label1.setText(com.zxc.language.Manager.getValue("game_chess_m2"));
					JOptionPane.showMessageDialog(null, "乙赢了");
				}

				people = data.getPeople();
			} else {

			}

		} else {
			JOptionPane.showMessageDialog(null, com.zxc.language.Manager.getValue("game_chess_m3"));
		}
	}
	
	private void refresh(){
		    int i=1;
		    end=false;
		    people=1;
		    label1.setText(com.zxc.language.Manager.getValue("game_chess_who1"));
		    while(i<=80){
		    	label[i].setIcon(new ImageIcon("./pic/chess/0.jpg"));
		    	data =new com.zxc.chess.bean.Data();
		    	i++;
		    }
	}
	
	private void regret(){
		int n = data.regret();
		if(n==-1){
			JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("game_chess_m4"));
		}else{
			end=false;
			label[n].setIcon(new ImageIcon("./pic/chess/0.jpg"));
			people=data.getPeople();
			if (people == 2) {
				label1.setText(com.zxc.language.Manager.getValue("game_chess_who2"));
			} else {
				label1.setText(com.zxc.language.Manager.getValue("game_chess_who1"));
			}
		}
	}

}

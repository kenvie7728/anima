package com.zxc.fight.ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ui {

	private JFrame frame;
	private JLabel label1, label2, label3, label4, label5, label6;
	private JButton button;
	private com.zxc.fight.bean.Role boss, user;
	private boolean end;
	private boolean start;
	private boolean userUpStart, bossUpStart;

	public Ui() {
		createRole();
	}

	//创建角色
	private void createRole() {
		boss = new com.zxc.fight.bean.Role();
		boss.setAtack(20);
		boss.setBlood(250);
		boss.setDefence(false);
		boss.setMagic(50);
		boss.setX(530);
		boss.setY(300);
		user = new com.zxc.fight.bean.Role();
		user.setAtack(20);
		user.setBlood(250);
		user.setDefence(false);
		user.setMagic(50);
		user.setX(530);
		user.setY(300);
		end = false;
		start = false;
		userUpStart = false;
		bossUpStart = false;
	}

	//创建窗口
	public void createWindow() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/fight.png"));
		
		this.createLabel();
		button = new JButton(com.zxc.language.Manager.getValue("game_fright_button"));
		button.setBounds(270, 20, 120, 20);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (!start) {
					refresh();

				}
			}
		});
		button.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				// System.out.println(event.getKeyCode());
				if (!end && start) {
					userOption(event);
				}
			}
		});

		frame.add(button);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				end = true;
			}
		});

		frame.setTitle(com.zxc.language.Manager.getValue("game_fright_title"));
		frame.setVisible(true);
	}

	//刷新
	private void refresh() {
		end=true;
		this.createRole();
		start = true;

		label1.setBounds(10, 50, 250, 20);
		label2.setBounds(410, 50, 250, 20);

		label3.setBounds(10, 100, 50, 20);
		label4.setBounds(410, 100, 50, 20);

		label5.setBounds(10, 300, 50, 150);
		label6.setBounds(530, 300, 50, 150);

		new bossThread().start();
        new addMagic().start();
	}

	//用户跳跃
	private void userOption(KeyEvent event) {
		int i = event.getKeyCode();
		if (i == 38) {
			// up
			if (!userUpStart) {
				userUpStart = true;
				new userUp().start();
			}
		} else if (i == 40) {
			// down
		} else if (i == 37) {
			// left
			if (label5.getLocation().x >= 0) {
				label5.setLocation(label5.getLocation().x - 10,
						label5.getLocation().y);
			}

		} else if (i == 39) {
			// right
			if (label5.getLocation().x <= 630) {
				label5.setLocation(label5.getLocation().x + 10,
						label5.getLocation().y);
			}

		} else if (i == 74) {
			// atack
			if (label5.getLocation().y == label6.getLocation().y) {
				if (Math.abs((label5.getLocation().x - label6.getLocation().x)) <= 50) {
					boss.setBlood(boss.getBlood() - user.getAtack());
					label2.setSize(boss.getBlood(), 20);
					if (label5.getLocation().x <= label6.getLocation().x) {
						// label5.setLocation(label5.getLocation().x-20,
						// label5.getLocation().y);
						label6.setLocation(label6.getLocation().x + 60,
								label5.getLocation().y);
					} else {
						// label5.setLocation(label5.getLocation().x+30,
						// label5.getLocation().y);
						label6.setLocation(label6.getLocation().x - 60,
								label5.getLocation().y);
					}

				}

			}

		}else if(i==75){
			
			if(user.getMagic()>=20){
			if(label5.getLocation().x <= label6.getLocation().x){
				label6.setLocation(label6.getLocation().x+100,label6.getLocation().y);
			
			}else{
				label6.setLocation(label6.getLocation().x-100,label6.getLocation().y);
				
			}
			user.setMagic(user.getMagic()-50);
			label3.setSize(user.getMagic(),20);
			boss.setBlood(boss.getBlood()-50);
			label2.setSize(boss.getBlood(),20);
			isWin();
			}
		}
		

	}

	//创建标签
	private void createLabel() {
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();

		try {
			label1.setIcon(new ImageIcon("./pic/fright/1.png"));
			label2.setIcon(new ImageIcon("./pic/fright/1.png"));
			label3.setIcon(new ImageIcon("./pic/fright/2.png"));
			label4.setIcon(new ImageIcon("./pic/fright/2.png"));
			
			ImageIcon image= new ImageIcon("./pic/fright/u1.png");
			image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
			label5.setIcon(image);
			
			ImageIcon image1= new ImageIcon("./pic/fright/c1.png");
			image1.setImage(image1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
			label6.setIcon(image1);
		
		} catch (Exception error) {

		}

		label1.setBounds(10, 50, 250, 20);
		label2.setBounds(410, 50, 250, 20);

		label3.setBounds(10, 100, 250, 20);
		label4.setBounds(410, 100, 250, 20);

		label5.setBounds(10, 300, 50, 150);
		label6.setBounds(530, 300, 50, 150);

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
	}

	//boss自动运动攻击
	private class bossThread extends Thread {
		public void run() {
			while (!end) {

				try {
					if(!bossUpStart){
						if(Math.random()-0.9>=0){
							bossUpStart=true;
							new bossUp().start();
						}
					}
					
					if (label5.getLocation().x - label6.getLocation().x > 50) {
						label6.setLocation(label6.getLocation().x + 10,
								label6.getLocation().y);
					} else if (label6.getLocation().x - label5.getLocation().x > 50) {
						label6.setLocation(label6.getLocation().x - 10,
								label6.getLocation().y);
					} else {
						if (Math.random() - 0.5 > 0) {
							user.setBlood(user.getBlood() - boss.getAtack());
							label1.setSize(user.getBlood(), 20);
							if (label5.getLocation().x <= label6.getLocation().x) {
								if (label5.getLocation().x >= 0)
									label5.setLocation(
											label5.getLocation().x - 60,
											label5.getLocation().y);
								else
									label5.setLocation(
											label5.getLocation().x + 60,
											label5.getLocation().y);
							} else {
								if (label5.getLocation().x <= 530)
									label5.setLocation(
											label5.getLocation().x + 60,
											label5.getLocation().y);
								else
									label5.setLocation(
											label5.getLocation().x - 60,
											label5.getLocation().y);
							}
						}

						if (Math.random() - 0.9 > 0) {
							if (boss.getMagic() >= 20) {
								boss.setMagic(boss.getMagic() - 150);
								label4.setSize(boss.getMagic(), 20);
								if (!user.isDefence()) {
									user.setBlood(user.getBlood() - 100);
									label1.setSize(user.getBlood(), 20);
									System.out.println("ko");
								}

							}
						}

					}
					isWin();
					Thread.sleep(100);
				} catch (Exception error) {

				}

			}
		}
	}

	//判断输赢
	private void isWin() {
		if (user.getBlood() <= 0) {
			start = false;
			end = true;
			JOptionPane.showMessageDialog(null, "boss胜利！");
		} else if (boss.getBlood() <= 0) {
			start = false;
			end = true;
			JOptionPane.showMessageDialog(null, "用户胜利！");
		}
	}

	private class userUp extends Thread {

		public void run() {
			boolean up = true;
			while (userUpStart) {
				
				try {
					if (up) {
						if (label5.getLocation().y != 100) {
							label5.setLocation(label5.getLocation().x,
									label5.getLocation().y - 10);
						} else {
							up = false;
						}
					} else {
						if (label5.getLocation().y != 300) {
							label5.setLocation(label5.getLocation().x,
									label5.getLocation().y + 10);
						} else {
							userUpStart = false;
						}
					}
					Thread.sleep(20);
				} catch (Exception error) {

				}

			}

		}
	}
	
	//boss跳跃
	private class bossUp extends Thread {

		public void run() {
			boolean up = true;
			while (bossUpStart) {
				
				try {
					if (up) {
						if (label6.getLocation().y != 100) {
							label6.setLocation(label6.getLocation().x,
									label6.getLocation().y - 10);
						} else {
							up = false;
						}
					} else {
						if (label6.getLocation().y != 300) {
							label6.setLocation(label6.getLocation().x,
									label6.getLocation().y + 10);
						} else {
							bossUpStart = false;
						}
					}
					Thread.sleep(20);
				} catch (Exception error) {

				}

			}

		}
	}
	
	private class addMagic extends Thread{
		
		public void run(){
		  while(!end){
			  try{
				
					boss.setMagic(boss.getMagic()+10);
					user.setMagic(user.getMagic()+10);
					label3.setSize(user.getMagic(),20);
					label4.setSize(boss.getMagic(),20);
				
				Thread.sleep(1000);
			  }catch(Exception error){
				  
			  }
		  }
		}
		
	}

}

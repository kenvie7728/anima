package com.zxc.car.ui;

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

	private int total;
	
	private JFrame frame;
	private JLabel label,l;
	private JLabel label1, label2, label3, label4, label5, label6, label7,label8;
	private RobotThread r1, r2, r3, r4, r5, r6, r7,r8;
	private JButton b;
	private boolean stop;
	private T1 tt;

	// 构造方法
	public Ui() {
		stop = false;
	}

	// 创建窗口
	public void createWindow() {
		this.createJfFrame();
		this.createJLabel();
		frame.setVisible(true);
	}

	// 外框初始化
	private void createJfFrame() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/car.png"));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle(com.zxc.language.Manager.getValue("game_car_title"));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				r1.exit();
				r2.exit();
				r3.exit();
				r4.exit();
				r5.exit();
				r6.exit();
				r7.exit();
				r8.exit();
				tt.exit();
			}
		});

		frame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (stop) {
					stop = false;
					setStop(stop);
				} else {
					stop = true;
					setStop(stop);
				}
			}
		});

		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				// System.out.println(event.getKeyCode());
				// 37 39
				userMove(event);
			}
		});
	}

	private void userMove(KeyEvent event) {
		if (event.getKeyCode() == 37) {
			if (label.getLocation().x >= 10)
				label.setLocation(label.getLocation().x - 10,
						label.getLocation().y);
		} else if (event.getKeyCode() == 39) {
			if (label.getLocation().x <= 620)
				label.setLocation(label.getLocation().x + 10,
						label.getLocation().y);
		}
	}

	private void setStop(boolean stop) {
		r1.setStop(stop);
		r2.setStop(stop);
		r3.setStop(stop);
		r4.setStop(stop);
		r5.setStop(stop);
		r6.setStop(stop);
		r7.setStop(stop);
		r8.setStop(stop);
	}

	// 创建标签
	private void createJLabel() {
		label = new JLabel();
		ImageIcon image= new ImageIcon("./pic/car/0.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label.setIcon(image);
		label.setBounds(320, 350, 50, 50);

		label1 = new JLabel();
		image= new ImageIcon("./pic/car/1.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label1.setIcon(image);
		label1.setSize(50, 50);

		label2 = new JLabel();
		image= new ImageIcon("./pic/car/2.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label2.setIcon(image);
		label2.setSize(50, 50);

		label3 = new JLabel();
		image= new ImageIcon("./pic/car/3.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label3.setIcon(image);
		label3.setSize(50, 50);
		
		label4 = new JLabel();
		image= new ImageIcon("./pic/car/4.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label4.setIcon(image);
		label4.setSize(50, 50);

		label5 = new JLabel();
		image= new ImageIcon("./pic/car/5.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label5.setIcon(image);
		label5.setSize(50, 50);

		label6 = new JLabel();
		image= new ImageIcon("./pic/car/6.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label6.setIcon(image);
		label6.setSize(50, 50);

		label7 = new JLabel();
		image= new ImageIcon("./pic/car/7.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label7.setIcon(image);
		label7.setSize(50, 50);

		label8 = new JLabel();
		image= new ImageIcon("./pic/car/ball.png");
		image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)); 
		label8.setIcon(image);
		label8.setSize(50, 50);
		
		frame.add(label);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		frame.add(label8);
		
		l=new JLabel("得分：0");
		l.setBounds(20,10,70,20);
		frame.add(l);
		
		b=new JButton("开始");
		b.setBounds(20,50,170,20);
		frame.add(b);
		
		b.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				// System.out.println(event.getKeyCode());
				// 37 39
				userMove(event);
			}
		});
		
		b.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						if(b.getText().equals("开始")){
						start();
						b.setText("暂停");}
					    else{
					    	if (stop) {
					    		b.setText("暂停");
								stop = false;
								setStop(stop);
							} else {
								b.setText("恢复");
								stop = true;
								setStop(stop);
							}
					    }
						}
				});
		
	}

	
	private void start(){
		total=0;
		l.setText("得分：0");
		T t = new T();
		t.start();
	}
	
	private class T extends Thread {
		public void run() {
			try {
				// System.out.println("y");
				r1 = new RobotThread(label1);
				r2 = new RobotThread(label2);
				r3 = new RobotThread(label3);
				r4 = new RobotThread(label4);
				r5 = new RobotThread(label5);
				r6 = new RobotThread(label6);
				r7 = new RobotThread(label7);
				r8 = new RobotThread(label8);
				tt = new T1();
				tt.start();

				r1.start();
				Thread.sleep(2000);

				r2.start();
				Thread.sleep(2000);

				r3.start();
				Thread.sleep(2000);

				r4.start();
				Thread.sleep(2000);

				r5.start();
				Thread.sleep(2000);

				r6.start();
				Thread.sleep(2000);

				r7.start();
				Thread.sleep(2000);
				
				r8.start();
				Thread.sleep(2000);
				// System.out.println("y");
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}

		}
	}

	private class T1 extends Thread {

		private boolean end = false;

		public void exit() {
			end = true;
		}

		public void run() {
			try {
				while (!end) {
					if ((Math
							.abs((label.getLocation().x - label1.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label1.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label2.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label2.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label3.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label3.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label4.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label4.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label5.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label5.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label6.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label6.getLocation().y) < 50))
						fail();

					if ((Math
							.abs((label.getLocation().x - label7.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label7.getLocation().y) < 50))
						fail();
					
					if ((Math
							.abs((label.getLocation().x - label8.getLocation().x)) < 50)
							&& (Math.abs(label.getLocation().y
									- label8.getLocation().y) < 50))
						get();
				}
			} catch (Exception error) {

			}
		}
	}

	private void get(){
		label8.setLocation((int)(Math.random()*700),0);
		total=total+10;
		l.setText("得分："+total);
	}
	
	private void fail() {
		r1.exit();
		r2.exit();
		r3.exit();
		r4.exit();
		r5.exit();
		r6.exit();
		r7.exit();
		r8.exit();
		tt.exit();
		b.setText("开始");
		JOptionPane.showMessageDialog(null, "游戏结束！");
	}

}

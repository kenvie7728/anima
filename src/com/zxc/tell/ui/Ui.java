package com.zxc.tell.ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.zxc.tell.dao.RobotControl;

public class Ui {

	private JFrame frame;
	private JTextArea textArea1, textArea2;
	private JScrollPane s1, s2;
	private JButton button;
	private JComboBox<String> c;
   private com.zxc.tell.dao.Free free=null;
   
	public Ui() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("robot");
		frame.setLayout(null);
	}

	public void createWindow() {
		button = new JButton("提问");
		button.setBounds(600, 430, 70, 20);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				startOrder();
			}
		});

		textArea1 = new JTextArea("你好，我是智能机器人，很荣幸能和你交流");
		textArea1.setFont(new Font("宋体", Font.BOLD, 20));
		textArea1.setEditable(false);
		textArea1.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		s1 = new JScrollPane(textArea1);
		s1.setBounds(20, 20, 650, 300);

		textArea2 = new JTextArea();
		textArea2.setFont(new Font("宋体", Font.BOLD, 20));
		s2 = new JScrollPane(textArea2);
		s2.setBounds(20, 350, 650, 70);

		/*textArea2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				System.out.println(event.getKeyCode());
				try {
					String s = new String(textArea2.getText().toCharArray(), 0,
							textArea2.getText().length());
					textArea2.setText(s);
					
					
					if (event.getKeyCode() == 10||event.getKeyCode() == 17)
						startOrder();
				
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
			}

			public void keyReleased(KeyEvent event) {
				
				if (event.getKeyCode()==10||event.getKeyCode() == 17) {
					textArea2.setText("");
					textArea1.setCaretPosition(0);
				}
			}
		});*/

		c = new JComboBox<String>();
		c.addItem("标准模式");
		c.addItem("学习模式");
		c.setBounds(20, 430, 120, 20);
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showMessage();
			}
		});

		frame.add(button);
		frame.add(s1);
		frame.add(s2);
		frame.add(c);

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/tell/ui.png"));

		frame.addWindowListener(
				new WindowAdapter(){
			public void windowClosed(WindowEvent event){
				exit();
			}
		});
		
		frame.setVisible(true);
		
		free=	new com.zxc.tell.dao.Free(this);
		free.start();
	}

	private void showMessage() {
		if (c.getSelectedItem().equals("学习模式")) {
			textArea1.append("" + '\r' + '\n' + "学习模式，输入格式：（问句$#$回答）");
			textArea1.setCaretPosition(textArea1.getText().length());
		}
	}

	private void startOrder() {

		free.set();
		
		if (textArea2.getText().equals("")) {

		} else if (c.getSelectedItem().equals("标准模式")) {
			String problem = textArea2.getText();
			String answer = new RobotControl().getAnswer(problem, this);
			textArea1.append("" + '\n' + '\r' + "user: " + problem);
			textArea1.append("" + '\n' + '\r' + "robot: " + answer);
			textArea2.setText("");
			textArea1.setCaretPosition(textArea1.getText().length());
		} else {
			String text = textArea2.getText();
			String[] s = text.split("\\$\\#\\$");
			if (s.length == 2) {
				new com.zxc.tell.dao.Learn().addProblemAndAnswer(s[0], s[1]);
				textArea1.append("" + '\n' + '\r' + "问句: " + s[0]);
				textArea1.append("" + '\n' + '\r' + "回答: " + s[1]);
				textArea1.append("" + '\n' + '\r' + "结果: 录入成功～");
				textArea2.setText("");
				textArea1.setCaretPosition(textArea1.getText().length());
			} else {
				textArea1.append("" + '\n' + '\r' + "结果:格式错误～ ");
			}
		}

	}

	public void exit() {
		
		free.exit();
	
		//frame.dispose();
		
	}
	
	public void addText(String str){
		textArea1.append(str);
		textArea1.setCaretPosition(textArea1.getText().length());
	}

}

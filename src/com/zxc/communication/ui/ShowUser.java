package com.zxc.communication.ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ShowUser {
	private JFrame frame = null;
    private JTextArea textArea1=null;
    private JTextArea textArea2=null;
    private JTextArea textArea3=null;
    private JTextArea textArea4=null;
    private JTextArea textArea5=null;
    
    public void showWindow(com.zxc.communication.bean.User user) {
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		frame = new JFrame();
		frame.setBounds((width - 500) / 2, (height - 300) / 2, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(com.zxc.language.Manager.getValue("tool_communication_show_title"));
		frame.setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/communication.png"));
		
		JLabel label1 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_show_name"));
		JLabel label2 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_show_phone"));
		JLabel label3 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_show_tel"));
		JLabel label4 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_show_qq"));
		JLabel label5 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_show_email"));

		label1.setBounds(10, 20, 90, 30);
		label2.setBounds(10, 60, 90, 30);
		label3.setBounds(10, 100, 90, 30);
		label4.setBounds(10, 140, 90, 30);
		label5.setBounds(10, 180, 90, 30);

		JButton button1 = new JButton(com.zxc.language.Manager.getValue("tool_communication_show_giveupButton"));
		button1.setBounds(250, 230, 90, 30);

		textArea1 = new JTextArea(user.getName());
		textArea2 = new JTextArea(user.getPhone());
		textArea3 = new JTextArea(user.getTel());
		textArea4 = new JTextArea(user.getQq());
		textArea5 = new JTextArea(user.getEmail());

		textArea1.setBounds(50, 20, 200, 30);
		textArea1.setFont(new Font("宋体", Font.BOLD, 20));
		textArea1.setEditable(false);
		
		textArea2.setBounds(50, 60, 200, 30);
		textArea2.setFont(new Font("宋体", Font.BOLD, 20));
		textArea2.setEditable(false);
		
		textArea3.setBounds(50, 100, 200, 30);
		textArea3.setFont(new Font("宋体", Font.BOLD, 20));
		textArea3.setEditable(false);
		
		textArea4.setBounds(50, 140, 200, 30);
		textArea4.setFont(new Font("宋体", Font.BOLD, 20));
		textArea4.setEditable(false);
		
		textArea5.setBounds(50, 180, 200, 30);
		textArea5.setFont(new Font("宋体", Font.BOLD, 20));
		textArea5.setEditable(false);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(button1);
		frame.add(textArea1);
		frame.add(textArea2);
		frame.add(textArea3);
		frame.add(textArea4);
		frame.add(textArea5);

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
                   exit();
			}
		});

		frame.setVisible(true);
	}

	private void exit() {
		frame.dispose();
	}
}

package com.zxc.communication.ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.zxc.communication.bean.User;

public class AddMessage {
	private JFrame frame = null;
    private JTextArea textArea1=null;
    private JTextArea textArea2=null;
    private JTextArea textArea3=null;
    private JTextArea textArea4=null;
    private JTextArea textArea5=null;
    private UiManager ui=null;
    
	public AddMessage() {

	}

	public void showWindow(UiManager f) {
		ui=f;
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		frame = new JFrame();
		frame.setBounds((width - 500) / 2, (height - 300) / 2, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(com.zxc.language.Manager.getValue("tool_communication_add_title"));
		frame.setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/communication.png"));
		
		JLabel label1 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_add_name"));
		JLabel label2 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_add_phone"));
		JLabel label3 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_add_tel"));
		JLabel label4 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_add_qq"));
		JLabel label5 = new JLabel(com.zxc.language.Manager.getValue("tool_communication_add_email"));

		label1.setBounds(10, 20, 90, 30);
		label2.setBounds(10, 60, 90, 30);
		label3.setBounds(10, 100, 90, 30);
		label4.setBounds(10, 140, 90, 30);
		label5.setBounds(10, 180, 90, 30);

		JButton button1 = new JButton(com.zxc.language.Manager.getValue("tool_communication_add_addButton"));
		button1.setBounds(50, 230, 90, 30);

		JButton button2 = new JButton(com.zxc.language.Manager.getValue("tool_communication_add_giveupButton"));
		button2.setBounds(350, 230, 90, 30);

		textArea1 = new JTextArea();
		textArea2 = new JTextArea();
		textArea3 = new JTextArea();
		textArea4 = new JTextArea();
		textArea5 = new JTextArea();

		textArea1.setBounds(50, 20, 200, 30);
		textArea1.setFont(new Font("宋体", Font.BOLD, 20));

		textArea2.setBounds(50, 60, 200, 30);
		textArea2.setFont(new Font("宋体", Font.BOLD, 20));

		textArea3.setBounds(50, 100, 200, 30);
		textArea3.setFont(new Font("宋体", Font.BOLD, 20));

		textArea4.setBounds(50, 140, 200, 30);
		textArea4.setFont(new Font("宋体", Font.BOLD, 20));

		textArea5.setBounds(50, 180, 200, 30);
		textArea5.setFont(new Font("宋体", Font.BOLD, 20));

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(button1);
		frame.add(button2);
		frame.add(textArea1);
		frame.add(textArea2);
		frame.add(textArea3);
		frame.add(textArea4);
		frame.add(textArea5);

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
                   addMessage(ui);
			}
		});

		button2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				exit();
			}
		});

		frame.setVisible(true);
	}

	private void exit() {
		frame.dispose();
	}
	
	private void addMessage(UiManager f){
		com.zxc.communication.bean.User user =new com.zxc.communication.bean.User();
		user.setName(textArea1.getText());
	    user.setPhone(textArea2.getText());
	    user.setTel(textArea3.getText());
	    user.setQq(textArea4.getText());
	    user.setEmail(textArea5.getText());
	    boolean success = new com.zxc.communication.dao.Writer().write(user);
	    if(success){
	    	com.zxc.communication.bean.UserList.addUser(user);
	    	ui.refresh();
	    	JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("tool_communication_add_successMessage"));
	    	com.zxc.system.log.Log.addOptionLog("communication","添加通信录信息！");
	    	frame.dispose();
	    }else{
	    	JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("tool_communication_add_failMessage"));
	    	frame.dispose();
	    }
	}

}

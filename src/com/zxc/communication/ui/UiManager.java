package com.zxc.communication.ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class UiManager {
	private List<com.zxc.communication.bean.User> list = null;
	private DefaultListModel<String> m = null;
	private JList<String> li = null;;
    private boolean change = false;
    private JTextArea textArea =null;
	
    // 构造方法
	public UiManager() {
		list = com.zxc.communication.bean.UserList.getUserList();
	}

	// 创建窗口
	public void createWindow() {
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		JFrame form = new JFrame();
		form.setTitle(com.zxc.language.Manager.getValue("tool_communication_title"));
		form.setResizable(false);
		form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		form.setBounds((width - 700) / 2, (height - 500) / 2, 700, 500);
		form.setLayout(null);
		form.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/communication.png"));
		this.windowAddControl(form);
		this.refresh();
		form.addWindowListener(
				new WindowAdapter(){
					public void windowClosed(WindowEvent event){
						if(change){
						saveBeforeExit();
						}
					}
				});
		form.setVisible(true);
		
	}

	//添加控件
	private void windowAddControl(JFrame frame) {
		this.windowAddList(frame);
		this.windowAddButton(frame);
		this.windowAddText(frame);
	}

	//添加列表
	private void windowAddList(JFrame frame) {
		m = new DefaultListModel<String>();
		li = new JList<String>(m);
		JScrollPane s = new JScrollPane(li);
		s.setBounds(10, 10, 670, 400);
		frame.add(s);

		li.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() >= 2) {
					showUserWindow();
				}
			}
		});
	}

	//添加按钮
	private void windowAddButton(JFrame frame) {
		JButton button1 = new JButton();
		button1.setText(com.zxc.language.Manager.getValue("tool_communication_addButton"));
		button1.setBounds(10, 430, 90, 30);
		frame.add(button1);
		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				showUserAddWindow();
			}
		});

		JButton button2 = new JButton();
		button2.setText(com.zxc.language.Manager.getValue("tool_communication_updateButton"));
		button2.setBounds(110, 430, 90, 30);
		frame.add(button2);

		button2.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						showUpdateWindow();
					    change=true;
					}
				});
		
		JButton button3 = new JButton();
		button3.setText(com.zxc.language.Manager.getValue("tool_communication_deleteButton"));
		button3.setBounds(210, 430, 90, 30);
		frame.add(button3);

		button3.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						if(li.getSelectedIndex()!=-1){
						deleteUser();
						com.zxc.system.log.Log.addOptionLog("communication","删除通信录信息！");
						change=true;
						}
					}
				});
		
		JButton button4 = new JButton();
		button4.setText(com.zxc.language.Manager.getValue("tool_communication_optionButton"));
		button4.setBounds(310, 430, 90, 30);
		frame.add(button4);

		button4.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						new com.zxc.system.log.Window().showOptionLog("communication");
					}
				});
		
		JButton button5 = new JButton();
		button5.setText(com.zxc.language.Manager.getValue("tool_communication_findButton"));
		button5.setBounds(600, 430, 90, 30);
		frame.add(button5);
		button5.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent event){
						   find();
					}
				});
	}

	//添加文本域
	private void windowAddText(JFrame frame) {
		textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.BOLD, 20));
		textArea.setBounds(410, 430, 180, 30);
		frame.add(textArea);
	}

	//显示用户信息
	private void showUserWindow() {
		new com.zxc.communication.ui.ShowUser().showWindow(list.get(li
				.getSelectedIndex()));
	}
	
	//显示通信录列表（刷新）
	public void refresh(){
		m.clear();
		com.zxc.communication.bean.UserList.sort();
		for (com.zxc.communication.bean.User temp : list) {
			m.add(m.getSize(), temp.getName() + "         " + temp.getPhone());
		}
	}
	
	//显示添加用户窗体
	public void showUserAddWindow(){
		new AddMessage().showWindow(this);
	}
	
	//删除用户
	public void deleteUser(){
		com.zxc.communication.bean.UserList.deleteUser(li.getSelectedIndex());
	    this.refresh();
	    JOptionPane.showMessageDialog(null,"删除成功！");
	}
	
	//退出前保存用户信息
	private void saveBeforeExit(){
		new com.zxc.communication.dao.Writer().write(com.zxc.communication.bean.UserList.getUserList());
	}
	
	//显示修改用户窗体
	private void showUpdateWindow(){
		new UpdateUser().showWindow(this, li.getSelectedIndex(),list.get(li.getSelectedIndex()));
	}
	
	//查询特定用户
	private void find(){
		String text=textArea.getText();
		m.clear();
		for (com.zxc.communication.bean.User temp : list) {
			if(temp.getName().indexOf(text)!=-1)
			m.add(m.getSize(), temp.getName() + "         " + temp.getPhone());
		}
	}
}

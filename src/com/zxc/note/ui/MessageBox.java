package com.zxc.note.ui;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 抽象类
 */
public abstract class MessageBox extends JFrame {

	protected JLabel label1, label2, label3, label4;
	protected JTextArea text1;
	protected JTextField text2, text3;
	protected JCheckBox c;
	protected JScrollPane s;
	protected Ui u;
	
	// 构造方法
	public void MessageBox() {
		
	}

	// 创建窗体
	public void createWindow(Ui u) {
		this.u=u;
		setWindow();
		setWindowTitle();
		addCom();
		this.setVisible(true);
	}

	// 窗体设置
	private void setWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
	}

	// 设置窗口标题
	private void setWindowTitle() {
		//this.setTitle("null");
	}

	// 添加控件
	private void addCom() {
		addJLabel();
		addField();
		addArea();
		addCheckBox();
	}

	// 添加标签
	private void addJLabel() {
		label1 = new JLabel(com.zxc.language.Manager.getValue("tool_note_messagePane_label1"));
		label1.setBounds(10, 20, 170, 20);
		this.add(label1);

		label2 = new JLabel(com.zxc.language.Manager.getValue("tool_note_messagePane_label2"));
		label2.setBounds(10, 60, 170, 20);
		this.add(label2);

		label3 = new JLabel(com.zxc.language.Manager.getValue("tool_note_messagePane_label3"));
		label3.setBounds(10, 100, 170, 20);
		this.add(label3);

		label4 = new JLabel(com.zxc.language.Manager.getValue("tool_note_messagePane_label4"));
		label4.setBounds(125, 20, 230, 20);
		this.add(label4);
	}

	// 添加文本框
	private void addField() {
		text2 = new JTextField();
		text2.setBounds(310, 20, 170, 20);
		this.add(text2);

		text3 = new JTextField();
		text3.setBounds(50, 60, 170, 20);
		this.add(text3);
	}

	//添加多选框
	public void addCheckBox(){
		c =new JCheckBox(com.zxc.language.Manager.getValue("tool_note_messagePane_comboBox"),false);
		c.setBounds(70,20,55,20);
	    this.add(c);
	}
	
	// 添加文本域
	private void addArea() {
           text1 =new JTextArea();
           text1.setFont(new Font("宋体",Font.BOLD,20));
           s =new JScrollPane(text1);
	       s.setBounds(50,100,400,120);
	       this.add(s);
	}

	// 添加按钮(需要重写)
	public abstract void addButton();
	
	//自定义行为
	public void setEdit(boolean i){
		    if(!i){
		    	text1.setEditable(false);
		    	text2.setEditable(false);
		    	text3.setEditable(false);
		    	c.setEnabled(false);
		    }
	}
}

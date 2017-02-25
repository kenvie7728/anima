package com.zxc.note.ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ui {

	public Ui() {
		File fp = new File("./dat");
		if (!fp.exists())
			fp.mkdir();
	}

	// 声明控件
	private JFrame frame = null;
	private JList<String> listBox = null;
	private DefaultListModel<String> m = null;
	private JScrollPane s = null, s1 = null;
	private JButton button1, button2, button3, button4, button5;
	private JTextField text1 = null;
	private JLabel label1 = null, label2 = null, label3 = null;
	private JTextArea text2 = null;

	//标识符，判断文件内容是否改变
	private boolean change=false;
	
	// 声明线程
	t th = new t();

	public void createWindow() {

		// 控件初始化
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/note.png"));
		m = new DefaultListModel<String>();
		listBox = new JList<String>(m);
		s = new JScrollPane(listBox);

		// 窗口设置
		frame.setResizable(false);
		frame.setTitle(com.zxc.language.Manager.getValue("tool_note_title"));
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);

		// 列表框设置
		s.setBounds(10, 10, 400, 400);

		// 按钮设置
		button1 = new JButton(com.zxc.language.Manager.getValue("tool_note_show"));
		button1.setBounds(10, 430, 70, 20);

		button2 = new JButton(com.zxc.language.Manager.getValue("tool_note_add"));
		button2.setBounds(110, 430, 70, 20);

		button3 = new JButton(com.zxc.language.Manager.getValue("tool_note_update"));
		button3.setBounds(210, 430, 70, 20);

		button4 = new JButton(com.zxc.language.Manager.getValue("tool_note_delete"));
		button4.setBounds(310, 430, 70, 20);

		button5 = new JButton(com.zxc.language.Manager.getValue("tool_note_find"));
		button5.setBounds(610, 430, 70, 20);

		// 文本框设置
		text1 = new JTextField();
		text1.setBounds(410, 430, 170, 20);

		// 标签设置
		label1 = new JLabel(com.zxc.language.Manager.getValue("tool_note_date"));
		label1.setBounds(430, 10, 170, 20);

		label2 = new JLabel(com.zxc.language.Manager.getValue("tool_note_time"));
		label2.setBounds(430, 50, 170, 20);

		label3 = new JLabel(com.zxc.language.Manager.getValue("tool_note_text"));
		label3.setBounds(430, 150, 170, 20);

		// 文本域设置
		text2 = new JTextArea();
		text2.setFont(new Font("宋体", Font.BOLD, 20));
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setEditable(false);
		s1 = new JScrollPane(text2);
		s1.setBounds(430, 190, 250, 220);

		// 添加控件
		frame.add(s);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(text1);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(s1);

		// 添加事件监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				th.tryStop();
				exit();
			}
		});

		listBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (listBox.getSelectedIndex() != -1) {
					showContent();
					if(event.getClickCount()>=2){
						showAllContent();
					}
				}
			}
		});

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (listBox.getSelectedIndex() != -1) {
					showAllContent();
				}
			}
		});

		button2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				change=true;
				createAddWindow();
			}
		});
		
		button3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (listBox.getSelectedIndex() != -1) {
					change=true;
					showUpdateContent();
				}
			}
		});

		button4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (listBox.getSelectedIndex() != -1) {
					change=true;
					deleteUser();
				}
			}
		});

		button5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				search();
			}
		});
		
		// 显示窗口
		frame.setVisible(true);

		// 启动线程
		th.start();

		// 获取数据
		com.zxc.note.bean.NoteList.getNoteList().clear();
		new com.zxc.note.dao.Reader().read();
		refresh();
	}

	//显示修改信息窗口
	private void showUpdateContent() {
		new com.zxc.note.ui.UpdateMessageBox().createWindow(
				this,
				com.zxc.note.bean.NoteList.getNoteList().get(
						listBox.getSelectedIndex()));
	}
	
	// 显示详细内容
	private void showAllContent() {
		new com.zxc.note.ui.LookMessageBox().createWindow(
				this,
				com.zxc.note.bean.NoteList.getNoteList().get(
						listBox.getSelectedIndex()));
	}

	// 显示概略内容
	private void showContent() {
		text2.setText(com.zxc.note.bean.NoteList.getNoteList()
				.get(listBox.getSelectedIndex()).getContent());

	}

	// 删除用户
	private void deleteUser() {
		if (listBox.getSelectedIndex() != -1) {
			com.zxc.note.bean.NoteList.getNoteList().remove(
					listBox.getSelectedIndex());
			refresh();
			JOptionPane.showMessageDialog(null, com.zxc.language.Manager.getValue("tool_note_message"));
		}
	}

	// 退出时保存数据
	private void exit() {
		if(change){
		new com.zxc.note.dao.Writer().write();
		}
	}

	// 创建添加用户窗体
	private void createAddWindow() {
		new AddMessageBox().createWindow(this);
	}

	// 获取系统时间
	private String getTime() {
		String time = com.zxc.language.Manager.getValue("tool_note_time");
		Calendar c = Calendar.getInstance();
		time = time + c.get(Calendar.HOUR_OF_DAY) + "时"
				+ c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒";
		return time;
	}

	// 获取系统日期
	private String getDate() {
		String date = com.zxc.language.Manager.getValue("tool_note_date");
		Calendar c = Calendar.getInstance();
		date = date + c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1)
				+ "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
		return date;
	}

	//查找特定元素
	private void search(){
		this.text2.setText("");
		m.clear();
		com.zxc.note.bean.NoteList.sort();
		List<com.zxc.note.bean.Note> list = com.zxc.note.bean.NoteList
				.getNoteList();
		for (com.zxc.note.bean.Note note : list) {
			if(note.getTitle().indexOf(this.text1.getText())!=-1){
			m.add(m.getSize(), note.getTitle());
			}
		}
	}
	
	// 刷新列表
	public void refresh() {
		m.clear();
		com.zxc.note.bean.NoteList.sort();
		List<com.zxc.note.bean.Note> list = com.zxc.note.bean.NoteList
				.getNoteList();
		for (com.zxc.note.bean.Note note : list) {
			m.add(m.getSize(), note.getTitle());
		}
	}

	private class t extends Thread {

		private boolean start = true;

		// 停止线程
		public void tryStop() {
			start = false;
		}

		public void run() {
			try {
				while (start) {
					label1.setText(getDate());
					label2.setText(getTime());
					Thread.sleep(1000);
				}
			} catch (Exception error) {
				System.out.println(error.getLocalizedMessage());
			}
		}
	}
}

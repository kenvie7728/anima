package com.zxc.filefinder;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ui {

	private JFrame frame;
	private JList<String> list;
	private DefaultListModel<String> m;
	private JTextField text1;
	private JButton button;
	private JComboBox<String> c;
	private JLabel label;
	private FileFinder f;
	private JScrollPane s;

	public Ui() {

	}

	public void createWindow() {
		this.addJFrame();
		this.add();
		frame.setVisible(true);
	}

	private void addJFrame() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/tool/finder.png"));
		frame.setSize(700, 500);
		frame.setResizable(false);
		frame.setTitle(com.zxc.language.Manager.getValue("tool_finder_title"));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	private void add() {
		m = new DefaultListModel<String>();
		list = new JList<String>(m);
		s = new JScrollPane(list);
		s.setBounds(20, 70, 650, 370);

		text1 = new JTextField();
		text1.setBounds(20, 10, 300, 20);

		button = new JButton(com.zxc.language.Manager.getValue("tool_finder_find"));
		button.setBounds(370, 10, 70, 20);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (label.getText().equals("线程未启动！")||label.getText().equals("查找结束～")) {
					find();
					button.setText(com.zxc.language.Manager.getValue("tool_finder_stop"));
				} else {
                       f.exit();
                       button.setText(com.zxc.language.Manager.getValue("tool_finder_find"));
				}

			}
		});
		c = new JComboBox<String>();
		c.setEditable(true);
		c.addItem("/");
		c.addItem("C:");
		c.addItem("D:");
		c.addItem("E:");
		c.addItem("F:");
		c.addItem("G:");
		c.setBounds(500, 10, 170, 20);

		label = new JLabel("线程未启动！");
		label.setBounds(20, 40, 500, 20);

		frame.add(s);
		frame.add(text1);
		frame.add(button);
		frame.add(c);
		frame.add(label);
	}

	private void find() {
		m.clear();
		f = new FileFinder(c.getSelectedItem().toString(), m, label,
				text1.getText(),button);
		f.start();
	}
}

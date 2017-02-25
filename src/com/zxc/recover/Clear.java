package com.zxc.recover;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Clear {

	private JFrame frame;
	private JProgressBar p;
	private JLabel l1, l2;
	private JButton b1, b2;

	public Clear() {

	}

	public void createWindow() {
		frame = new JFrame();
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(com.zxc.language.Manager.getValue("clear_title"));
		frame.setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/reset/u2.png"));
		this.addProgressBar();
		this.addButton();
		this.addLabel();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void addProgressBar() {
		p = new JProgressBar();
		p.setBounds(20, 20, 370, 20);
		frame.add(p);
	}

	private void addLabel() {
		l1 = new JLabel("0%");
		l2 = new JLabel(com.zxc.language.Manager.getValue("clear_label"));
		l1.setBounds(430, 20, 170, 20);
		l2.setBounds(20, 60, 300, 20);
		frame.add(l1);
		frame.add(l2);
	}

	private void addButton() {
		b1 = new JButton(com.zxc.language.Manager.getValue("clear_b1"));
		b2 = new JButton(com.zxc.language.Manager.getValue("clear_b2"));
		b1.setBounds(20, 200, 170, 20);
		b2.setBounds(270, 200, 170, 20);
		frame.add(b1);
		frame.add(b2);

		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				recover();
			}
		});

		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				exit();
			}
		});

	}

	private void recover() {
		int i = JOptionPane.showConfirmDialog(null,com.zxc.language.Manager.getValue("clear_message"));
		if (i == 0) {
			new T().start();
		}

	}

	private void exit() {
		frame.dispose();
	}

	private class T extends Thread {

		public void run() {
			try {
				b1.setEnabled(false);
				b2.setEnabled(false);

				File fp;

				fp = new File("./dat/user.dat");
				if (fp.exists())
					fp.delete();
				p.setValue(10);
				l1.setText("10%");
				l2.setText("delete user.dat");

				fp = new File("./dat/note.dat");
				if (fp.exists())
					fp.delete();

				p.setValue(20);
				l1.setText("20%");
				l2.setText("delete note.dat");

				fp = new File("./dat");
				if (fp.exists())
					fp.delete();

				p.setValue(30);
				l1.setText("30%");
				l2.setText("delete dat");

				fp = new File("./log/communication.dat");
				if (fp.exists())
					fp.delete();

				p.setValue(40);
				l1.setText("40%");
				l2.setText("delete communication.dat");

				fp = new File("./log/Error.dat");
				if (fp.exists())
					fp.delete();

				p.setValue(50);
				l1.setText("50%");
				l2.setText("delete error.dat");

				fp = new File("./log/System.dat");
				if (fp.exists())
					fp.delete();

				p.setValue(60);
				l1.setText("60%");
				l2.setText("delete System.dat");

				fp = new File("./log");
				if (fp.exists())
					fp.delete();

				p.setValue(70);
				l1.setText("70%");
				l2.setText("delete log");

				FileInputStream in = new FileInputStream("./databases/main");
				FileOutputStream out = new FileOutputStream("./setting/main");
				int i;
				while ((i = in.read()) != -1) {
					out.write(i);
				}
				in.close();
				out.close();

				p.setValue(100);
				l1.setText("100%");
				l2.setText(com.zxc.language.Manager.getValue("clear_message2"));
				JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("clear_message2"));

				b1.setEnabled(true);
				b2.setEnabled(true);
			} catch (Exception error) {

			}
		}

	}

}

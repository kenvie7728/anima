package com.zxc.pet.dao;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FindFile {

	private String rude;
	private String str;
	private DefaultListModel<String> m;
    private JFrame frame;
	private JLabel label;
	
	public void find(String rude, String str, DefaultListModel<String> m) {
		
		this.rude = rude;
		this.str = str;
		this.m = m;
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300,100);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		label=new JLabel();
		frame.add(label);
		
		frame.setVisible(true);
		
		com.zxc.pet.bean.FindList.clear();
		new T().start();
	}

	private void findTheFile(File fp) {
		try {
			label.setText("正在查找："+fp.getAbsolutePath());
			File[] f = fp.listFiles();
			for (File ff : f) {
				if (ff.isFile()) {
					if (ff.getName().indexOf(str) != -1) {
						m.add(m.getSize(), ff.getName());
					    com.zxc.pet.bean.FindList.addValue(ff.getAbsolutePath());
					}
				} else {
					findTheFile(ff);
				}
			}
		} catch (Exception error) {

		}
	}

	private class T extends Thread {

		@Override
		public void run() {
			findTheFile(new File(rude));
			frame.dispose();
		}

	}

}

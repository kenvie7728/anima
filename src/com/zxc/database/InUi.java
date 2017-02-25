package com.zxc.database;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InUi extends Pane {

	private List<String> list1 = new LinkedList<String>();
	private List<String> list2 = new LinkedList<String>();
	private List<String> list3 = new LinkedList<String>();

	public InUi() {
		super();
	}

	@Override
	public void showWindow() {
		frame.setTitle(com.zxc.language.Manager.getValue("in_title"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/setting/u2.png"));
		c1.setEnabled(false);
		c2.setEnabled(false);
		c3.setEnabled(false);

		button1.setEnabled(false);

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				new T2().start();
			}
		});

		button2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JFileChooser c = new JFileChooser();
				int i = c.showOpenDialog(null);
				if (i == 0) {
					new T1(c.getSelectedFile().getAbsolutePath()).start();
				}
			}
		});

		frame.setVisible(true);

	}

	private void save() {

		File fp = new File(l.getText());
		long total = fp.length();
		long now = 0;
		p.setVisible(true);

		if (c1.isSelected())
			try {

				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream("./setting/main", false), "UTF-8");
				BufferedWriter bu2 = new BufferedWriter(out);
				for (String str : list1) {
					bu2.write(str + '\n');
					now = now + str.length();
					int pro = (int) (now * 100 / total);
					p.setValue(pro);
					l.setText(pro + "%");
				}
				bu2.close();
				out.close();

			} catch (Exception error) {

			}

		if (c2.isSelected())
			try {

				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream("./dat/communication.dat", false),
						"UTF-8");
				BufferedWriter bu2 = new BufferedWriter(out);
				for (String str : list1) {
					bu2.write(str + '\n');
					now = now + str.length();
					int pro = (int) (now * 100 / total);
					p.setValue(pro);
					l.setText(pro + "%");
				}
				bu2.close();
				out.close();

			} catch (Exception error) {

			}

		if (c3.isSelected())
			try {

				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream("./dat/user.dat", false), "UTF-8");
				BufferedWriter bu2 = new BufferedWriter(out);
				for (String str : list1) {
					bu2.write(str + '\n');
					now = now + str.length();
					int pro = (int) (now * 100 / total);
					p.setValue(pro);
					l.setText(pro + "%");
				}
				bu2.close();
				out.close();

			} catch (Exception error) {

			}

		p.setValue(100);
		l.setText("100%");
		JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("in_message"));
		frame.dispose();

	}

	private void load(String rude) {
		button1.setEnabled(true);

		try {
			int type = 0;
			InputStreamReader in = new InputStreamReader(new FileInputStream(
					rude), "UTF-8");
			BufferedReader bu1 = new BufferedReader(in);
			bu1.readLine();
			while (bu1.ready()) {

				String str = bu1.readLine();
				if (str.equals("setting------")) {
					type = 1;
				} else if (str.equals("communication------")) {
					type = 2;
				} else if (str.equals("note------")) {
					type = 3;
				} else {
					if (type == 1)
						list1.add(str);
					else if (type == 2)
						list2.add(str);
					else if (type == 3)
						list3.add(str);
				}

			}
			bu1.close();
			in.close();

		} catch (Exception error) {

		}

		l.setVisible(true);
		l.setText(rude);

		if (list1.size() != 0) {
			c1.setSelected(true);
			c1.setEnabled(true);
		}
		if (list2.size() != 0) {
			c2.setSelected(true);
			c2.setEnabled(true);
		}
		if (list3.size() != 0) {
			c3.setSelected(true);
			c3.setEnabled(true);
		}
	}
	
	private class T1 extends Thread{
		
		private String rude;
		
		public T1(String rude){
			this.rude=rude;
		}
		
		public void run(){
			load(rude);
		}
	}
	
	private class T2 extends Thread{
		public void run(){
			save();
		}
	}

}

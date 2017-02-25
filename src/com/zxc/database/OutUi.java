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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OutUi extends Pane {

	public OutUi() {
		super();
	}

	@Override
	public void showWindow() {
		frame.setTitle(com.zxc.language.Manager.getValue("out_title"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/setting/u3.png"));
		
		button1.setText(com.zxc.language.Manager.getValue("out_save"));
		button2.setVisible(false);

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JFileChooser c = new JFileChooser();
				if (c.showSaveDialog(null) == 0) {
					File fp =new File(c.getSelectedFile().getAbsolutePath());
					if(fp.exists()){
						int i=JOptionPane.showConfirmDialog(null,"文件已存在，是否覆盖？");
						if(i==0)new T(c.getSelectedFile().getAbsolutePath()).start();
					}else{
						new T(c.getSelectedFile().getAbsolutePath()).start();
					}
				}
			}
		});

		frame.setVisible(true);
	}

	private void save(String rude) {

		try {
			File fp;
			p.setVisible(true);
			l.setVisible(true);
			
			long total=0,now=0;
			
			fp = new File("./setting/main");
			if (fp.exists())
			total=total+fp.length();
			
			fp = new File("./dat/user.dat");
			if (fp.exists())
			total=total+fp.length();
			
			fp = new File("./dat/note.dat");
			if (fp.exists())
			total=total+fp.length();
			
			if (true) {
				InputStreamReader in = new InputStreamReader(
						new FileInputStream("./setting/main"), "UTF-8");
				BufferedReader bu1 = new BufferedReader(in);
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(rude, false), "UTF-8");
				BufferedWriter bu2 = new BufferedWriter(out);
				bu2.write("title");
				bu1.close();
				in.close();
				bu2.close();
				out.close();
			}

			

			fp = new File("./setting/main");
			if (fp.exists())
				if (c1.isSelected()) {
					InputStreamReader in = new InputStreamReader(
							new FileInputStream("./setting/main"), "UTF-8");
					BufferedReader bu1 = new BufferedReader(in);
					OutputStreamWriter out = new OutputStreamWriter(
							new FileOutputStream(rude, true), "UTF-8");
					BufferedWriter bu2 = new BufferedWriter(out);
					bu2.write("" + '\n' + "setting------" + '\n');
					while (bu1.ready()) {
						String str = bu1.readLine();
						bu2.write(str + '\n');
						now=now+str.length();
						int pro=(int)(now*100/total);
						p.setValue(pro);
						l.setText(pro+"%"+"       deal with : "+str);
					}
					bu2.write("setting------");
					bu1.close();
					in.close();
					bu2.close();
					out.close();
				}

			fp = new File("./dat/user.dat");
			if (fp.exists())
				if (c2.isSelected()) {
					InputStreamReader in = new InputStreamReader(
							new FileInputStream("./dat/user.dat"), "UTF-8");
					BufferedReader bu1 = new BufferedReader(in);
					OutputStreamWriter out = new OutputStreamWriter(
							new FileOutputStream(rude, true), "UTF-8");
					BufferedWriter bu2 = new BufferedWriter(out);
					bu2.write("" + '\n' + "communication------" + '\n');
					while (bu1.ready()) {
						String str = bu1.readLine();
						bu2.write(str + '\n');
						now=now+str.length();
						int pro=(int)(now*100/total);
						p.setValue(pro);
						l.setText(pro+"%"+"       deal with : "+str);
					}
					bu2.write("communication------");
					bu1.close();
					in.close();
					bu2.close();
					out.close();
				}

			fp = new File("./dat/note.dat");
			if (fp.exists())
				if (c3.isSelected()) {
					InputStreamReader in = new InputStreamReader(
							new FileInputStream("./dat/note.dat"), "UTF-8");
					BufferedReader bu1 = new BufferedReader(in);
					OutputStreamWriter out = new OutputStreamWriter(
							new FileOutputStream(rude, true), "UTF-8");
					BufferedWriter bu2 = new BufferedWriter(out);
					bu2.write("" + '\n' + "note------" + '\n');
					while (bu1.ready()) {
						String str = bu1.readLine();
						bu2.write(str + '\n');
						now=now+str.length();
						int pro=(int)(now*100/total);
						p.setValue(pro);
						l.setText(pro+"%"+"       deal with : "+str);
					}
					bu2.write("note------");
					bu1.close();
					in.close();
					bu2.close();
					out.close();
				}
            p.setValue(100);
            l.setText(com.zxc.language.Manager.getValue("out_message1"));
			JOptionPane.showMessageDialog(null,com.zxc.language.Manager.getValue("out_message"));
			frame.dispose();
		} catch (Exception error) {

		}

	}

	private class T extends Thread {

		private String rude;

		public T() {
			super();
		}

		public T(String rude) {
			this();
			this.rude = rude;
		}

		public void run() {
			save(rude);
		}
	}

}

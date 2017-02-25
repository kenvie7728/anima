package com.zxc.pet.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.ref.Reference;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PetUi {

	private JFrame frame;
	private JTextArea text2;
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8,
			menu9;
	private DefaultListModel<String> m1, m2, m3;
	private JList<String> listBox1, listBox2, listBox3;
	private JScrollPane s1, s2, s3;
	private JComboBox<String> com1;
	private JTextField text1;
	private JButton button1;
	private JLabel label1, label2, label3, label5;
	private JLabel j1, j2, j3, j4, j5, j6, j7, j8;
	private JMenuItem item1, item2, item3, item4, item5, item6, item7, item8,
			item9, item10, item11, item12, item13, item14;
	private JMenuItem item15, item16, item17, item18, item19, item20;
	private JMenuItem item21, item22, item23, item24, item25, item26, item27;
	private JMenuItem item28, item29, item30, item31, item32, item33, item34;
	private boolean music = true;
	private com.zxc.pet.dao.ShowPic showPic = null;

	public void createPetWindow() {

		// 窗口设置
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"./pic/main/ui.png"));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(com.zxc.language.Manager.getValue("ui_title"));
		frame.setSize(800, 600);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				try {
					showPic.exit();
					File fp = new File("./temp/exit.dat");
					if (fp.exists())
						fp.delete();
					fp = new File("./temp/exit.dat");
					fp.createNewFile();
				} catch (Exception error) {
					com.zxc.system.log.Log.addErrorLog(error.getMessage());
				}
			}
		});

		// 主菜单
		menuBar = new JMenuBar();
		menu1 = new JMenu(com.zxc.language.Manager.getValue("ui_data"));
		menu2 = new JMenu(com.zxc.language.Manager.getValue("ui_information"));
		menu3 = new JMenu(
				com.zxc.language.Manager.getValue("ui_popularization"));
		menu4 = new JMenu(com.zxc.language.Manager.getValue("ui_resource"));
		menu5 = new JMenu(com.zxc.language.Manager.getValue("ui_accessory"));
		menu6 = new JMenu(com.zxc.language.Manager.getValue("ui_setting"));
		menu7 = new JMenu(com.zxc.language.Manager.getValue("ui_link"));
		menu8 = new JMenu(com.zxc.language.Manager.getValue("ui_tell"));
		menu9 = new JMenu(com.zxc.language.Manager.getValue("ui_help"));

		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		menuBar.add(menu6);
		menuBar.add(menu7);
		menuBar.add(menu8);
		menuBar.add(menu9);

		// 子级菜单1
		item1 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_data_start"));
		item2 = new JMenuItem(com.zxc.language.Manager.getValue("ui_data_save"));
		item3 = new JMenuItem(com.zxc.language.Manager.getValue("ui_data_exit"));

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new com.zxc.recover.Ui().createWindow();
			}

		});

		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new com.zxc.recover.Ui().recoverUi();
			}

		});

		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}

		});

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);

		// 子级菜单2
		item4 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_information_cartoon"));
		item5 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_information_anime"));
		item6 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_information_exhibition"));

		menu2.add(item4);
		menu2.add(item5);
		menu2.add(item6);

		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					String[] order = { "./anima/animationIntelligence.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./anima/cartoonIntelligence.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./anima/diffuseFairSummary.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		// 子级菜单3
		item7 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_summary"));
		item8 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_picture"));
		item9 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_music"));
		item10 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_note"));
		item11 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_dance"));
		item12 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_near"));
		item13 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_cosplay"));
		item14 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_game"));
		item32 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_popularization_video"));

		menu3.add(item7);
		menu3.add(item8);
		menu3.add(item9);
		menu3.add(item10);
		menu3.add(item11);
		menu3.add(item12);
		menu3.add(item13);
		menu3.add(item14);
		menu5.add(item32);

		item7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "1.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./anima/theOriginalPainting.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "2.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./anima/lightNovelLibrary.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "3.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "4.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "5.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./information/show.exe", "6.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item32.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new com.zxc.system.log.Ui().createWindow();
			}

		});

		// 子级菜单4
		item15 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_resource_picture"));
		item16 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_resource_music"));
		item17 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_resource_video"));
		menu4.add(item15);
		menu4.add(item16);
		menu4.add(item17);

		item15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] s = new String[2];
					s[0] = "./photo/pic.exe";
					s[1] = com.zxc.setting.Content.getMap().get("pic_rude");
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(s);
				} catch (Exception error) {

				}
			}

		});

		item16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] s = new String[2];
					s[0] = "./mp3/mp3.exe";
					s[1] = com.zxc.setting.Content.getMap().get("pic_rude");
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(s);

				} catch (Exception error) {

				}
			}

		});

		item17.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] s = new String[2];
					s[0] = "./avi/avi.exe";
					s[1] = com.zxc.setting.Content.getMap().get("pic_rude");
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(s);

				} catch (Exception error) {

				}
			}

		});

		// 子级菜单5
		item33 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_accessory_tools"));
		item34 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_accessory_games"));
		menu5.add(item33);
		menu5.add(item34);

		item33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.zxc.tool.ToolsPane().createWindow();
			}
		});

		item34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.zxc.tool.GamePane().createWindow();
			}
		});

		// 子级菜单6
		item18 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_setting_in"));
		item19 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_setting_out"));
		item20 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_setting_set"));
		menu6.add(item18);
		menu6.add(item19);
		menu6.add(item20);

		item18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new com.zxc.database.InUi().showWindow();
			}

		});

		item19.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new com.zxc.database.OutUi().showWindow();
			}

		});

		item20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showSetting();
			}

		});

		// 子级菜单7
		item21 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_forum"));
		item22 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_music"));
		item23 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_video"));
		item24 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_picture"));
		item25 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_note"));
		item26 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_link_project"));
		menu7.add(item21);
		menu7.add(item22);
		menu7.add(item23);
		menu7.add(item24);
		menu7.add(item25);
		menu7.add(item26);

		item21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "1.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "2.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item23.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "3.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item24.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "4.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item25.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "5.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		item26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] order = { "./url/web.exe", "6.html" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}

		});

		// 子级菜单8
		item27 = new JMenuItem(com.zxc.language.Manager.getValue("ui_tell_ai"));
		menu8.add(item27);

		item27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.zxc.tell.ui.Ui().createWindow();
			}
		});

		// 子级菜单9
		item28 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_help_help"));
		item29 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_help_tell"));
		item30 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_help_about"));
		item31 = new JMenuItem(
				com.zxc.language.Manager.getValue("ui_help_term"));
		menu9.add(item28);
		menu9.add(item29);
		menu9.add(item30);
		menu9.add(item31);

		item28.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec("./help/help.exe");
				} catch (Exception error) {

				}
			}

		});

		item29.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec("./help/tell.exe");
				} catch (Exception error) {

				}
			}

		});

		item30.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec("./help/about.exe");
				} catch (Exception error) {

				}
			}

		});

		item31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec("./help/term.exe");
				} catch (Exception error) {

				}
			}

		});

		// 列表框1
		m1 = new DefaultListModel<String>();
		listBox1 = new JList<String>(m1);
		s1 = new JScrollPane(listBox1);
		s1.setBounds(10, 60, 320, 150);

		listBox1.addMouseListener(
        		new MouseAdapter(){
        			public void mouseClicked(MouseEvent event){
        				if(event.getClickCount()>=2){
        					text2.setText("");
        					readText();
        				}
        			}
        		});
		
		
		// 列表框2
		m2 = new DefaultListModel<String>();
		listBox2 = new JList<String>(m2);
		s2 = new JScrollPane(listBox2);
		// s2.setBounds(580, 60, 200, 180);
		label5 = new JLabel();
		label5.setBounds(580, 60, 200, 180);
		frame.add(label5);

		// 列表框3
		//m3 = new DefaultListModel<String>();
		//listBox3 = new JList<String>(m3);
		text2=new JTextArea();
		text2.setEditable(false);
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setFont(new Font("宋体",Font.BOLD,20));
		s3 = new JScrollPane(text2);
		s3.setBounds(10, 250, 770, 290);

		// 下拉列表框
		com1 = new JComboBox<String>();
		com1.setBounds(10, 220, 100, 20);
        com1.addItem("简介");
		com1.addItem("小说");
        com1.addItem("动漫科普");
        com1.addItem("动漫杂谈");
        com1.setSelectedIndex(0);
        
		// 文本框
		text1 = new JTextField();
		text1.setBounds(125, 220, 120, 20);

		// 按钮设置
		button1 = new JButton("搜索");
		button1.setBounds(260, 220, 70, 20);
        button1.addMouseListener(
        		new MouseAdapter(){
        			public void mouseClicked(MouseEvent event){
        				m1.clear();
        				new com.zxc.pet.dao.Control().sendOrder(com1.getSelectedItem().toString(),text1.getText(), m1);
        			}
        		});
		
		// 标签设置(图片显示)
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();

		try {
			ImageIcon image = new ImageIcon("./pic/main/u1.png");
			image.setImage(image.getImage().getScaledInstance(235, 95,
					Image.SCALE_DEFAULT));
			// label1.setIcon(image);
			image = new ImageIcon("./pic/main/u2.png");
			image.setImage(image.getImage().getScaledInstance(115, 65,
					Image.SCALE_DEFAULT));
			label2.setIcon(image);
			image = new ImageIcon("./pic/main/u3.png");
			image.setImage(image.getImage().getScaledInstance(115, 65,
					Image.SCALE_DEFAULT));
			label3.setIcon(image);
		} catch (Exception error) {
			System.out.println(error.getLocalizedMessage());
		}

		label1.setBounds(335, 60, 235, 95);
		label2.setBounds(335, 175, 115, 65);
		label3.setBounds(465, 175, 115, 65);

		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setForeground(Color.blue);
		
		label2.setToolTipText("按一下-------图片播放");
		label3.setToolTipText("按一下-------图片暂停");
		
		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {

			}
		});

		label2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				showPic.startThread();
			}
		});

		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				showPic.stopThread();
			}
		});

		// 标签设置（功能）
		j1 = new JLabel();
		j2 = new JLabel();
		j3 = new JLabel();
		j4 = new JLabel();
		j5 = new JLabel();
		j6 = new JLabel();
		j7 = new JLabel();
		j8 = new JLabel();

		j1.setToolTipText("动画情报--------最全的情报在这里");
		j2.setToolTipText("漫展汇总---------想了解漫展情况，按这里~");
		j3.setToolTipText("漫画推荐----------很多漫画喔");
		j4.setToolTipText("文件查找----------文件不记得在哪，不用怕，按我");
		j5.setToolTipText("刷新--------刷一下");
		j6.setToolTipText("程序设置---------不喜欢现在的情况，设置一下");
		j7.setToolTipText("人机对话-------------机器人也很智能的");
		j8.setToolTipText("背景音乐-----------音乐无处不在");
		
		try {
			ImageIcon image = new ImageIcon("./pic/main/1.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j1.setIcon(image);

			image = new ImageIcon("./pic/main/2.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j2.setIcon(image);

			image = new ImageIcon("./pic/main/3.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j3.setIcon(image);

			image = new ImageIcon("./pic/main/4.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j4.setIcon(image);

			image = new ImageIcon("./pic/main/5.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j5.setIcon(image);

			image = new ImageIcon("./pic/main/6.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j6.setIcon(image);

			image = new ImageIcon("./pic/main/7.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j7.setIcon(image);

			image = new ImageIcon("./pic/main/8.png");
			image.setImage(image.getImage().getScaledInstance(70, 40,
					Image.SCALE_DEFAULT));
			j8.setIcon(image);
		} catch (Exception error) {

		}

		j1.setBounds(10, 10, 70, 40);
		j2.setBounds(110, 10, 70, 40);
		j3.setBounds(210, 10, 70, 40);
		j4.setBounds(310, 10, 70, 40);
		j5.setBounds(410, 10, 70, 40);
		j6.setBounds(510, 10, 70, 40);
		j7.setBounds(610, 10, 70, 40);
		j8.setBounds(710, 10, 70, 40);

		j1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				try {
					String[] order = { "./anima/animationIntelligence.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}
		});

		j2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				try {
					String[] order = { "./anima/diffuseFairSummary.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}
		});

		j3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				try {
					String[] order = { "./anima/theOriginalPainting.exe" };
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec(order);
				} catch (Exception error) {

				}
			}
		});

		j4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				new com.zxc.filefinder.Ui().createWindow();
			}
		});

		j5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				refresh();
			}
		});

		j6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				showSetting();
			}
		});

		j7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				new com.zxc.tell.ui.Ui().createWindow();
			}
		});

		j8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				music();
			}
		});

		frame.setLayout(null);
		frame.setJMenuBar(menuBar);
		frame.add(s1);
		frame.add(s2);
		frame.add(s3);
		frame.add(com1);
		frame.add(text1);
		frame.add(button1);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(j1);
		frame.add(j2);
		frame.add(j3);
		frame.add(j4);
		frame.add(j5);
		frame.add(j6);
		frame.add(j7);
		frame.add(j8);

		try {
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("./bgMusic.exe");
		} catch (Exception error) {

		}

		showPic = new com.zxc.pet.dao.ShowPic(this);
		showPic.start();

		m1.clear();
		new com.zxc.pet.dao.Control().sendOrder(com1.getSelectedItem().toString(),text1.getText(), m1);
		
		text2.setText("程序版本：1.0"+'\n');
		text2.append("制作者：陈陈苏"+'\n');
		
		frame.setVisible(true);
	}

	private void readText(){
		if(listBox1.getSelectedIndex()!=-1)
		new com.zxc.pet.dao.Control().sendOrder(listBox1.getSelectedIndex(),com1.getSelectedItem().toString(),this);
	}
	
	private void showSetting() {
		new com.zxc.setting.Ui(com.zxc.language.Manager.getType(), this)
				.createWindow();
	}

	private void exit() {
		frame.dispose();
	}

	public void setLanguage() {
		menu1.setText(com.zxc.language.Manager.getValue("ui_data"));
		menu2.setText(com.zxc.language.Manager.getValue("ui_information"));
		menu3.setText(com.zxc.language.Manager.getValue("ui_popularization"));
		menu4.setText(com.zxc.language.Manager.getValue("ui_resource"));
		menu5.setText(com.zxc.language.Manager.getValue("ui_accessory"));
		menu6.setText(com.zxc.language.Manager.getValue("ui_setting"));
		menu7.setText(com.zxc.language.Manager.getValue("ui_link"));
		menu8.setText(com.zxc.language.Manager.getValue("ui_tell"));
		menu9.setText(com.zxc.language.Manager.getValue("ui_help"));

		item1.setText(com.zxc.language.Manager.getValue("ui_data_start"));
		item2.setText(com.zxc.language.Manager.getValue("ui_data_save"));
		item3.setText(com.zxc.language.Manager.getValue("ui_data_exit"));
		item4.setText(com.zxc.language.Manager
				.getValue("ui_information_cartoon"));
		item5.setText(com.zxc.language.Manager.getValue("ui_information_anime"));
		item6.setText(com.zxc.language.Manager
				.getValue("ui_information_exhibition"));
		item7.setText(com.zxc.language.Manager
				.getValue("ui_popularization_summary"));
		item8.setText(com.zxc.language.Manager
				.getValue("ui_popularization_picture"));
		item9.setText(com.zxc.language.Manager
				.getValue("ui_popularization_music"));
		item10.setText(com.zxc.language.Manager
				.getValue("ui_popularization_note"));
		item11.setText(com.zxc.language.Manager
				.getValue("ui_popularization_dance"));
		item12.setText(com.zxc.language.Manager
				.getValue("ui_popularization_near"));
		item13.setText(com.zxc.language.Manager
				.getValue("ui_popularization_cosplay"));
		item14.setText(com.zxc.language.Manager
				.getValue("ui_popularization_game"));
		item15.setText(com.zxc.language.Manager.getValue("ui_resource_picture"));
		item16.setText(com.zxc.language.Manager.getValue("ui_resource_music"));
		item17.setText(com.zxc.language.Manager.getValue("ui_resource_video"));
		item18.setText(com.zxc.language.Manager.getValue("ui_setting_in"));
		item19.setText(com.zxc.language.Manager.getValue("ui_setting_out"));
		item20.setText(com.zxc.language.Manager.getValue("ui_setting_set"));
		item21.setText(com.zxc.language.Manager.getValue("ui_link_forum"));
		item22.setText(com.zxc.language.Manager.getValue("ui_link_music"));
		item23.setText(com.zxc.language.Manager.getValue("ui_link_video"));
		item24.setText(com.zxc.language.Manager.getValue("ui_link_picture"));
		item25.setText(com.zxc.language.Manager.getValue("ui_link_note"));
		item26.setText(com.zxc.language.Manager.getValue("ui_link_project"));
		item27.setText(com.zxc.language.Manager.getValue("ui_tell_ai"));
		item28.setText(com.zxc.language.Manager.getValue("ui_help_help"));
		item29.setText(com.zxc.language.Manager.getValue("ui_help_tell"));
		item30.setText(com.zxc.language.Manager.getValue("ui_help_about"));
		item31.setText(com.zxc.language.Manager.getValue("ui_help_term"));
		item32.setText(com.zxc.language.Manager
				.getValue("ui_popularization_video"));
		item33.setText(com.zxc.language.Manager.getValue("ui_accessory_tools"));
		item34.setText(com.zxc.language.Manager.getValue("ui_accessory_games"));
	}

	private void refresh() {
		text1.setText("");
		m1.clear();
		m2.clear();
	}

	public void addText(String text){
		text2.append(text+'\n');
	}
	
	public void setImage(String rude, String content) {
		try {
			
			label5.setIcon(null);
			
			ImageIcon image = new ImageIcon(rude);
			
			image.setImage(image.getImage().getScaledInstance(200, 180,
					Image.SCALE_DEFAULT));
			label5.setIcon(image);
			label1.setText(content);
			label5.setToolTipText(content);
			image=null;
			
		} catch (Exception error) {

		}
	}

	private void music() {

		if (music) {

			music = false;

			try {
				ImageIcon image = new ImageIcon("./pic/main/9.png");
				image.setImage(image.getImage().getScaledInstance(70, 40,
						Image.SCALE_DEFAULT));
				j8.setIcon(image);
				File fp = new File("./temp/stop.dat");
				if (fp.exists())
					fp.delete();
				if (!fp.exists())
					fp.createNewFile();

			} catch (Exception error) {

			}

		} else {

			music = true;

			try {
				ImageIcon image = new ImageIcon("./pic/main/8.png");
				image.setImage(image.getImage().getScaledInstance(70, 40,
						Image.SCALE_DEFAULT));
				j8.setIcon(image);
				File fp = new File("./temp/start.dat");
				if (fp.exists())
					fp.delete();
				if (!fp.exists())
					fp.createNewFile();
			} catch (Exception error) {

			}

		}

	}

}

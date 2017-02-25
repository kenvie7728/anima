package com.zxc.tell.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Reader extends Thread {
	public void run() {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(
					"./data/tell/baike"), "UTF-8");
			BufferedReader bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.BaiKe.add(bu.readLine(), bu.readLine());
			}
			bu.close();
			in.close();

			in = new InputStreamReader(new FileInputStream(
					"./data/tell/four.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Word1.add(bu.readLine());
			}
			bu.close();
			in.close();

			in = new InputStreamReader(new FileInputStream(
					"./data/tell/three.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Word2.add(bu.readLine());
			}
			bu.close();
			in.close();

			in = new InputStreamReader(new FileInputStream(
					"./data/tell/two.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Word3.add(bu.readLine());
			}
			bu.close();
			in.close();
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/stand.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Sentence.addMap2(bu.readLine(),bu.readLine());
			}
			bu.close();
			in.close();
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/user.dat"), "UTF-8");
			bu = new BufferedReader(in);
			if(bu.ready())bu.readLine();
			while (bu.ready()) {
				com.zxc.tell.bean.Sentence.addMap(bu.readLine(),bu.readLine());
			}
			bu.close();
			in.close();
			
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/free.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Free.addValue(bu.readLine());
			}
			bu.close();
			in.close();
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/default.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Tail.addValue(bu.readLine());
			}
			bu.close();
			in.close();
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/theme.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				com.zxc.tell.bean.Theme.addValue(bu.readLine(),bu.readLine());
			}
			bu.close();
			in.close();
			
			in = new InputStreamReader(new FileInputStream(
					"./data/tell/english.dat"), "UTF-8");
			bu = new BufferedReader(in);
			while (bu.ready()) {
				String key=bu.readLine();
				String value=bu.readLine();
				try{
					key=key.substring(3,key.length());
					//System.out.println("-------------------"+key);
					value=value.substring(3,value.length());
				}catch(Exception error){
					
				}
				com.zxc.tell.bean.Tran.addValue(key, value);
				bu.readLine();
				
			}
			bu.close();
			in.close();
			
			System.out.println("read success!");
		} catch (Exception error) {
System.out.println(error.getMessage());
		}
	}
}

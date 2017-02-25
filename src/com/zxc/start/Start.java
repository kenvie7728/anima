package com.zxc.start;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Start {
	
	public static void main(String[] args) {
		
		new FileManager().createFile();
		
		readData();
		
		readIni();
		

	}

	private static void readData() {
		new com.zxc.tell.dao.Reader().start();
	    new com.zxc.communication.dao.Reader().run();
	}
	
	private static void readIni(){
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./setting/main"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.setting.Content.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/chinese"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.Chinese.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/english"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.English.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/japan"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.Japan.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/korea"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.Korea.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/russian"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.Russian.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
			
		}
		
		try{
			InputStreamReader in =new InputStreamReader(new FileInputStream("./language/french"),"UTF-8");
		    BufferedReader bu =new BufferedReader(in);
		    while(bu.ready()){
		    	String s =bu.readLine();
		    	bu.readLine();
		    	String[] str=s.split("\\=");
		    	com.zxc.language.French.addValue(str[0],str[1]);
		    }
		    bu.close();
		    in.close();
		}catch(Exception error){
		
		}
		
		com.zxc.language.Manager.setType(Integer.parseInt(com.zxc.setting.Content.getMap().get("language")));
		
		System.out.println("read setting success!");
		
		new com.zxc.pet.ui.PetUi().createPetWindow();
	}
	
}

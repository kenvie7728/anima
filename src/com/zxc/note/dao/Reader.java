package com.zxc.note.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Reader {

	//读入记事本数据
	public void read() {
		try {
             InputStreamReader in =new InputStreamReader(new FileInputStream("./dat/note.dat"),"UTF-8");
		     BufferedReader bu =new BufferedReader(in);
		     while(bu.ready()){
		    	 com.zxc.note.bean.Note note =new com.zxc.note.bean.Note();
		    	 note.setTitle(bu.readLine());
		    	 note.setContent(bu.readLine());
		    	 note.setWriteTime(bu.readLine());
		    	 note.setGoalTime(bu.readLine());
		    	 if(bu.readLine().equals("1"))note.setRemind(true);
		    	 else note.setRemind(false);
		    	 com.zxc.note.bean.NoteList.addNote(note);
		     }
		     bu.close();
		     in.close();
		} catch (Exception error) {

		}
	}
	
}

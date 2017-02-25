package com.zxc.note.dao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer {

	public void write() {
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream("./dat/note.dat", false), "UTF-8");
            BufferedWriter bu =new BufferedWriter(out);
			List<com.zxc.note.bean.Note> list = com.zxc.note.bean.NoteList
					.getNoteList();
			for (com.zxc.note.bean.Note note : list) {
                  bu.write(note.getTitle()+'\r'+'\n');
                  bu.write(note.getContent()+'\r'+'\n');
                  bu.write(note.getWriteTime()+'\r'+'\n');
                  bu.write(note.getGoalTime()+'\r'+'\n');
                  if(note.isRemind())bu.write("1"+'\r'+'\n');
                  else bu.write("0"+'\r'+'\n');
			}
			bu.close();
			out.close();
		} catch (Exception error) {

		}
	}
	
	public void write(com.zxc.note.bean.Note note){
		try{
		OutputStreamWriter out = new OutputStreamWriter(
				new FileOutputStream("./dat/note.dat", true), "UTF-8");
        BufferedWriter bu =new BufferedWriter(out);
        bu.write(note.getTitle()+'\r'+'\n');
        bu.write(note.getContent()+'\r'+'\n');
        bu.write(note.getWriteTime()+'\r'+'\n');
        bu.write(note.getGoalTime()+'\r'+'\n');
        if(note.isRemind())bu.write("1"+'\r'+'\n');
        else bu.write("0"+'\r'+'\n');
        bu.close();
		out.close();
		}catch(Exception error){
			
		}
	}

}

package com.zxc.note.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NoteList {
       
	private static List<Note> list =new LinkedList<Note>();
       
       //添加元素
	public static void addNote(Note note){
		list.add(note);
	}
	
	//获取列表
	public static List<Note> getNoteList(){
		return list;
	}
	
	//排序
	public static void sort(){
		Collections.sort(list);
	}
	
}

package com.zxc.tell.dao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class Learn {

	public void addProblemAndAnswer(String problem, String answer) {
		if (com.zxc.tell.bean.Sentence.getMap().get(problem) == null) {
			com.zxc.tell.bean.Sentence.addMap(problem, answer);
			T t =new T(false,""+'\r'+'\n'+problem+'\r'+'\n'+answer);
			t.start();
		} else {
			StringBuffer bu = new StringBuffer();
			bu.append(com.zxc.tell.bean.Sentence.getMap().get(problem))
					.append("#").append(answer);
			com.zxc.tell.bean.Sentence.remove(problem);
			com.zxc.tell.bean.Sentence.addMap(problem, bu.toString());
			T t =new T(true);
			t.start();
		}
	}
	
	private class T extends Thread{
		
		private boolean b;
		private String s;
		public T(){
			super();
		}
		
		public T(boolean b){
			this();
			this.b=b;
		}
		
		public T(boolean b,String s){
			this();
			this.b=b;
			this.s=s;
		}
		
		@Override
		public void run(){
	
			try{
			if(b){
				OutputStreamWriter out =new OutputStreamWriter(new FileOutputStream("./data/tell/user.dat",false),"UTF-8");
				BufferedWriter bu =new BufferedWriter(out);
				for(String s:com.zxc.tell.bean.Sentence.getList()){
					bu.write(s+'\r'+'\n'+com.zxc.tell.bean.Sentence.getMap().get(s)+'\r'+'\n');
				}
				bu.close();
				out.close();
			}else{
				OutputStreamWriter out =new OutputStreamWriter(new FileOutputStream("./data/tell/user.dat",true),"UTF-8");
				BufferedWriter bu =new BufferedWriter(out);
				bu.write(s);
				bu.close();
				out.close();
			}
		    }catch(Exception error){
			
		    }
			
		}
		
	}

}

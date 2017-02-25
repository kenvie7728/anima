package com.zxc.start;

import java.io.File;

public class FileManager {
       
	public void createFile(){
		try{
			File fp;
			
			fp=new File("./log");
			if(!fp.exists())fp.mkdir();
		
			fp=new File("./dat");
			if(!fp.exists())fp.mkdir();
			
			fp=new File("./temp");
			if(!fp.exists())fp.mkdir();
			
			fp=new File("./information");
			if(!fp.exists())fp.mkdir();
			
		}catch(Exception error){
			
		}
	}
	
}

package com.zxc.communication.dao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer {

	//追加保存
	public boolean write(com.zxc.communication.bean.User user) {
		try {

			OutputStreamWriter f = new OutputStreamWriter(new FileOutputStream(
					"./dat/user.dat", true), "UTF-8");
			BufferedWriter bu = new BufferedWriter(f);
			bu.write(user.getName() + '\r' + '\n');
			bu.write(user.getPhone() + '\r' + '\n');
			bu.write(user.getTel() + '\r' + '\n');
			bu.write(user.getQq() + '\r' + '\n');
			bu.write(user.getEmail() + '\r' + '\n');
			bu.close();
			f.close();
		} catch (Exception error) {
		com.zxc.system.log.Log.addErrorLog(error.getLocalizedMessage());
			return false;
		}
		return true;
	}

	//覆盖保存
	public boolean write(List<com.zxc.communication.bean.User> list) {

		try {
             OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./dat/user.dat",false),"UTF-8");
		     BufferedWriter bu=new BufferedWriter(out);
		     for(com.zxc.communication.bean.User user:list){
		    	 bu.write(user.getName() + '\r' + '\n');
					bu.write(user.getPhone() + '\r' + '\n');
					bu.write(user.getTel() + '\r' + '\n');
					bu.write(user.getQq() + '\r' + '\n');
					bu.write(user.getEmail() + '\r' + '\n');
		     }
		     bu.close();
		     out.close();
		} catch (Exception error) {
			return false;
		}
		return true;
	}
}

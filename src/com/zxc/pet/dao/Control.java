package com.zxc.pet.dao;

import javax.swing.DefaultListModel;

public class Control {

	public void sendOrder(int index,String order,com.zxc.pet.ui.PetUi u){
		if (order.equals("小说")){
			new ReadeText(u,com.zxc.pet.bean.FindList.getValue(index)).start();
		}else{
			new ReadeText(u,com.zxc.pet.bean.FindList.getValue(index)).start();
		}
	}
	
	public void sendOrder(String order, String str, DefaultListModel<String> m) {
		if (order.equals("小说")) {
			dispatcher1(m, str);
		}else if(order.equals("动漫科普")){
			dispatcher2(m, str);
		}else if(order.equals("动漫杂谈")){
			dispatcher3(m, str);
		}else if(order.equals("简介")){
			dispatcher4(m, str);
		}
	}

	private void dispatcher1(DefaultListModel<String> m, String str) {
		new FindFile().find("./data/novel", str, m);
	}
	
	private void dispatcher2(DefaultListModel<String> m, String str) {
		new FindFile().find("./data/kepu", str, m);
	}
	
	private void dispatcher3(DefaultListModel<String> m, String str) {
		new FindFile().find("./data/zatan", str, m);
	}
	
	private void dispatcher4(DefaultListModel<String> m, String str) {
		new FindFile().find("./data/start", str, m);
	}

}

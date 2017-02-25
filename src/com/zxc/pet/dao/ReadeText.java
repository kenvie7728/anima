package com.zxc.pet.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadeText extends Thread {

	private com.zxc.pet.ui.PetUi u;
	private String rude;

	public ReadeText() {

	}

	public ReadeText(com.zxc.pet.ui.PetUi u, String rude) {
		this.u = u;
		this.rude = rude;
	}

	@Override
	public void run() {

		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(
					rude), "GBK");
			BufferedReader bu = new BufferedReader(in);
			while (bu.ready()) {
				u.addText(bu.readLine());
			}

			bu.close();
			in.close();
		} catch (Exception error) {

		}

	}

}

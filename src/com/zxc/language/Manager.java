package com.zxc.language;

public class Manager {
	private static int type = 0;

	public static int getType() {
		return type;
	}

	public static void setType(int i) {
		type = i;
	}

	public static String getValue(String key) {
		if (type == 0)
			return Chinese.getMap().get(key);
		if (type == 1)
			return English.getMap().get(key);
		if (type == 2)
			return Japan.getMap().get(key);
		if (type == 3)
			return Korea.getMap().get(key);
		if (type == 4)
			return Russian.getMap().get(key);
		if (type == 5)
			return French.getMap().get(key);
		return null;
	}

}

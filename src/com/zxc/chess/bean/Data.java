package com.zxc.chess.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Data {

	private int step;
	private int[] exist;
	private int people;
	private Stack<Integer> stack;

	public Data() {

		step = 0;
		exist = new int[81];
		people = 1;
		stack = new Stack<Integer>();

	}

	private void change(int n, int p) {

		exist[n] = p;
		if (people == 1) {
			people = 2;
		} else {
			people = 1;
		}
		if(p!=0)stack.push(n);

}

	public boolean done(int n) {

		if (exist[n] == 0) {
			exist[n] = people;
			this.change(n, people);
			step++;
			
			return true;
		} else {
			return false;
		}

	}

	public int getPeople() {
		return people;
	}

	public int regret() {

		if (step == 0) {
			return -1;
		} else {
			step--;
			int n = stack.pop();
			this.change(n, 0);
			return n;
		}

	}

	public int Win(int n, int people) {

		boolean win = false;
		int y = (n - 1) / 10;
		int i = y * 10 + 1;
		int i1 = i + 5;
		int x = n % 10;
		if (x == 0)
			x = 10;

		//横行判断
		while (i <= i1) {
			if (exist[i] == people)
				if (exist[i + 1] == people)
					if (exist[i + 2] == people)
						if (exist[i + 3] == people)
							if (exist[i + 4] == people)
								win = true;
			i++;
		}

		//竖行判断
		int y1 = 0;
		while (y1 <= 5) {
			if (exist[((y1) * 10 + x)] == people)
				if (exist[((y1 + 1) * 10 + x)] == people)
					if (exist[((y1 + 2) * 10 + x)] == people)
						if (exist[((y1 + 3) * 10 + x)] == people)
							if (exist[((y1 + 4) * 10 + x)] == people)
								win = true;
			y1++;
		}

		//右斜判断
		List<Integer> list = new LinkedList<Integer>();
		int num = y * 10 + x;
		list.add(num);
		num = num - 11;
		while (num > 0) {
			list.add(num);
			num = num - 11;
		}
		num = y * 10 + x;
		num = num + 11;
		while (num < 81) {
			list.add(num);
			num = num + 11;
		}
		Collections.sort(list);
		int nn = 0;
		while (nn <= 4) {
			if (exist[list.get(nn)] == people)
				if (exist[list.get(nn + 1)] == people)
					if (exist[list.get(nn + 2)] == people)
						if (exist[list.get(nn + 3)] == people)
							if (exist[list.get(nn + 4)] == people)
								win = true;
			nn++;
		}

		//左斜判断
		list.clear();
	    num = y * 10 + x;
		list.add(num);
		num = num - 9;
		while (num > 0) {
			list.add(num);
			num = num - 9;
		}
		num = y * 10 + x;
		num = num + 9;
		while (num < 81) {
			list.add(num);
			num = num + 9;
		}
		Collections.sort(list);
		nn = 0;
		while (nn <= 4) {
			if (exist[list.get(nn)] == people)
				if (exist[list.get(nn + 1)] == people)
					if (exist[list.get(nn + 2)] == people)
						if (exist[list.get(nn + 3)] == people)
							if (exist[list.get(nn + 4)] == people)
								win = true;
			nn++;
		}
		
		
		if (win)
			return people;

		return 0;
	}

}

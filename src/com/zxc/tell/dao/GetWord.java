package com.zxc.tell.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class GetWord {
	// 逆向最大匹配
	public String deal(String problem) {
		// 已确定的关键词链表
		LinkedList<String> list = new LinkedList<String>();

		// 临时链表，用于储存匹配的所有关键词
		List<String> temp_list = new LinkedList<String>();

		// 临时关键词链表
		List<String> temp_keys_list;

		// 临时关键词SET
		TreeSet<String> temp_set = new TreeSet<String>();

		// 词语数组，用于确定已匹配关键词
		int length = problem.length(), i = 0;
		boolean[] word = new boolean[length + 1];
		while (i <= length) {
			word[i] = false;
			i++;
		}

		// 分割数组，用于标志停顿
		/*
		 * 1表示属于某个词 0表示悬空 2表示分割
		 */
		int[] w = new int[length + 1];
		while (i <= length) {
			w[i] = 0;
			i++;
		}

		// 尝试匹配四字关键词
		temp_keys_list = com.zxc.tell.bean.Word1.getList();
		for (String key : temp_keys_list) {
			if (problem.indexOf(key) != -1) {
				temp_list.add(key);
			}
		}

		for (String key : temp_list) {
			int position = problem.indexOf(key);
			boolean exist = true;
			if (!word[position])
				if (!word[position + 1])
					if (!word[position + 2])
						if (!word[position + 3])
							exist = false;

			if (!exist) {
				temp_set.add(key);
				word[position] = true;
				word[position + 1] = true;
				word[position + 2] = true;
				word[position + 3] = true;
			} else {
				for (String k : temp_set) {
					int position_temp = problem.indexOf(k);
					if (Math.abs((position - position_temp)) < 4) {
						if (position > position_temp) {
							temp_set.remove(k);
							temp_set.add(key);
							word[position_temp] = false;
							word[position_temp + 1] = false;
							word[position_temp + 2] = false;
							word[position_temp + 3] = false;
							word[position] = true;
							word[position + 1] = true;
							word[position + 2] = true;
							word[position + 3] = true;
						}
						break;
					}

				}
			}
		}

		// 生成匹配4字关键词
		for (String key : temp_set) {
			list.add(key);
			System.out.println("four_key:" + key);
		}

		// 清空临时链表
		temp_list.clear();

		temp_set.clear();

		// 尝试匹配3字关键字
		temp_keys_list = com.zxc.tell.bean.Word2.getList();
		for (String key : temp_keys_list) {
			if (problem.indexOf(key) != -1) {
				temp_list.add(key);
			}
		}

		for (String key : temp_list) {
			int position = problem.indexOf(key);
			boolean exist = true;
			if (!word[position])
				if (!word[position + 1])
					if (!word[position + 2])
						exist = false;

			if (!exist) {
				temp_set.add(key);
				word[position] = true;
				word[position + 1] = true;
				word[position + 2] = true;
			} else {
				for (String k : temp_set) {
					int position_temp = problem.indexOf(k);

					if ((Math.abs((position - position_temp)) < 3)) {
						if (position > position_temp) {
							temp_set.remove(k);
							temp_set.add(key);
							word[position_temp] = false;
							word[position_temp + 1] = false;
							word[position_temp + 2] = false;
							word[position_temp + 3] = false;
							word[position] = true;
							word[position + 1] = true;
							word[position + 2] = true;
							word[position + 3] = true;
						}
						break;
					}

				}
			}
		}

		// 生成匹配3字关键字
		for (String key : temp_set) {
			list.add(key);
			System.out.println("three_key:" + key);
		}

		// 清空临时链表
		temp_list.clear();

		temp_set.clear();

		// 尝试匹配2字关键字
		temp_keys_list = com.zxc.tell.bean.Word3.getList();
		for (String key : temp_keys_list) {
			if (problem.indexOf(key) != -1) {
				temp_list.add(key);
			}
		}

		for (String key : temp_list) {
			int position = problem.indexOf(key);
			boolean exist = true;
			if (!word[position])
				if (!word[position + 1])
					exist = false;

			if (!exist) {
				temp_set.add(key);
				word[position] = true;
				word[position + 1] = true;
			} else {
				for (String k : temp_set) {
					int position_temp = problem.indexOf(k);

					if (Math.abs((position - position_temp)) < 2) {
						if (position > position_temp) {
							temp_set.remove(k);
							temp_set.add(key);
							word[position_temp] = false;
							word[position_temp + 1] = false;
							word[position_temp + 2] = false;
							word[position] = true;
							word[position + 1] = true;
							word[position + 2] = true;
						}
						break;
					}

				}
			}
		}

		// 生成匹配2字关键字
		for (String key : temp_set) {
			list.add(key);
			System.out.println("two_key:" + key);
		}

		// 释放资源
		temp_list.clear();

		temp_set.clear();

		// 处理句子
		for (String key : list) {
			int l = problem.indexOf(key);
			int n = key.length() - 1;
			int ii = 0;
			while (ii < n) {
				w[l + ii] = 1;
				ii++;
			}
			w[l + ii] = 2;
		}

		// 输出句子
		int start = 0, stop = problem.length() - 1;
		char[] ch = problem.toCharArray();
		String words = new String();
		while (start <= stop) {
			if (w[start] == 0)
				words = words + ch[start] + "/";
			else if (w[start] == 1)
				words = words + ch[start];
			else
				words = words + ch[start] + "/";
			start++;
		}
		//System.out.println("右匹配：" + words);
		return words;
	}
}
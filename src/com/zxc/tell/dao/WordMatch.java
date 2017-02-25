package com.zxc.tell.dao;

import java.util.List;

public class WordMatch {

	public String getAnswerOnUser(String problem) {
		String content = null;
		char c = problem.charAt(0);
		if (((c <= 'z') && (c >= 'a')) || ((c <= 'Z') && (c >= 'A'))) {
			content = problem;

			return com.zxc.tell.bean.Sentence.getMap().get(problem);
		} else {
			content = new com.zxc.tell.dao.GetWord().deal(problem);
		}

		int max = 1;
		int now = 0;
		String standProblem = null;

		String[] str = content.replaceAll(" ", "").split("\\/");
		List<String> list = com.zxc.tell.bean.Sentence.getList();

		out: for (String s : list) {
			now = 0;
			for (String te : str) {
				if (s.equals(te)) {
					standProblem = s;
					break out;
				}
				if (s.indexOf(te) != -1)
					now++;
			}
			if (now >= max) {
				max = now;
				standProblem = s;
			}
		}
		if (standProblem == null)
			return null;
		return com.zxc.tell.bean.Sentence.getMap().get(standProblem);
	}

	public String getAnswerOnStand(String problem) {
		
		String content = null;
		char c = problem.charAt(0);
		if (((c <= 'z') && (c >= 'a')) || ((c <= 'Z') && (c >= 'A'))) {
			content = problem;
			return com.zxc.tell.bean.Sentence.getMap2().get(problem);
		} else {
			content = new com.zxc.tell.dao.GetWord().deal(problem);
		}
		

		int max = 1;
		int now = 0;
		String standProblem = null;

		String[] str = content.replaceAll(" ", "").split("\\/");
		List<String> list = com.zxc.tell.bean.Sentence.getList2();

		out: for (String s : list) {
			now = 0;
			for (String te : str) {
				if (s.equals(te)) {
					standProblem = s;
					break out;
				}
				if (s.indexOf(te) != -1)
					now++;
			}
			if (now >= max) {
				max = now;
				standProblem = s;
			}
		}
		if (standProblem == null)
			return null;
		return com.zxc.tell.bean.Sentence.getMap2().get(standProblem);
	}

}

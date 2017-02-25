package com.zxc.tell.dao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Computer {

	private Stack<Double> s1 = new Stack<Double>();
	private Stack<Character> s2 = new Stack<Character>();
	private Queue<Double> q1 = new LinkedList<Double>();
	private Queue<Character> q2 = new LinkedList<Character>();

	public String getResult(String el) throws Exception{

		//补全算数式
		if (!el.endsWith("=")) {
			el = el + '=';
		}
		
		//把数字和运算符压进队列
		int i = 0, n = el.length() - 1;
		char[] ch = el.toCharArray();
		while (i <= n) {
			int j = i;
			if ((ch[j] <= '9') && (ch[j] >= '0')) {

				while (true) {
					if (((ch[j] >= '0') && (ch[j] <= '9')) || (ch[j] == '.')) {
						j++;
					} else {
						break;
					}

				}
				double num = Double.parseDouble(new String(ch, i, j - i));
				q1.add(num);
				q2.add(ch[j]);
			} else {
				q2.add(ch[j]);
			}
			i = j + 1;
		}

		
		//表达式运算
		try{
			if(q2.peek()=='(')s2.add(q2.poll());
			s1.add(q1.poll());
			Queue<Character> q3= new LinkedList<Character>();
			
			for(char c:q2){
				if(c=='('){
					s2.add(c);
				}else if(c==')'){
					while((s1.size()>1)&&(s2.peek()!='(')){
						double t1=s1.pop();
						double t2=s1.pop();
						char t3 =s2.pop();
						t1=this.getAnaly(t1, t2, t3);
					    s1.push(t1);
					}
				}else if(c=='='){
					while(s1.size()>1){
						double t1=s1.pop();
						double t2=s1.pop();
						char t3 =s2.pop();
						t1=this.getAnaly(t1, t2, t3);
					    s1.push(t1);
					}
					
					if(s1.peek()-s1.peek().intValue()<=0.0001){
						return "计算结果:"+s1.peek().intValue();
					}
					return "计算结果:"+s1.peek();
				}else{
					if(this.compare(c)==1){
						double t1 = s1.pop();
						t1=this.getAnaly(t1, q1.poll(),c);
						s1.add(t1);
					}else{
						if(c=='-'){s1.add(-q1.poll());c='+';}
						else s1.add(q1.poll());
						s2.add(c);
					}
					
				}
				
			}
			
		}catch(Exception error){
			System.out.println("error:"+error.getMessage());
		error.printStackTrace();
		}
		
		return null;
	}

	private double getAnaly(double a,double b,char c){
		System.out.println("el"+a+c+b);
		if(c=='+'){
			return a+b;
		}else if(c=='-'){
			return a-b;
		}else if(c=='*'){
			return a*b;
		}else{
			return a/b;
		}
	}
	
	private int compare(char c) {
		if (s2.size() == 0) {
			if (c == '*' || c == '/')
				return 1;
			else
				return -1;
		}
		char a = s2.peek();
		if (c == '(')
			return 1;
		else if (c == '*' || c == '/') {
			if (a == ')')
				return -1;
			else if (a == '(')
				return 0;
			else {
				return 1;
			}
		} else if (c == '+' || c == '-') {
			return -1;
		}
		return 0;
	}

}

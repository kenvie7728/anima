package com.zxc.tell.dao;

public class RobotControl {

	public String getAnswer(String problem, com.zxc.tell.ui.Ui ui) {
		String answer = null;

		if (problem.startsWith("#")) {
			// 尝试调用命令
			answer = new Control().startControl(problem, ui);
		} else if (((problem.charAt(0) >= '0') && (problem.charAt(0) <= '9'))
				|| (problem.startsWith("("))) {
			// 尝试运算
			try {
				answer = new Computer().getResult(problem);
			} catch (Exception error) {
				answer = "运算出错～";
			}
		} else {
			// 调用下级分发器
			try{
				if(Character.isLetter(problem.charAt(0)))
				answer=this.traslation(problem);
			}catch(Exception error){
				
			}
			
			if(answer!=null)return answer;
			
			answer = this.dispenser(problem);
			answer = this.dealWith(answer);
		}

		return answer;
	}

	private String traslation(String problem){
		return com.zxc.tell.bean.Tran.getValue(problem);
	}
	
	private String dealWith(String answer) {
		String[] s = answer.split("\\#");
		int n = s.length;
		int num = (int) (Math.random() * n);
		return s[num];
	}

	private String dispenser(String problem) {

		String answer = null;

		// 尝试匹配百科
		answer = (String) com.zxc.tell.bean.BaiKe.getTree().get(problem);
		if (answer != null)
			return answer;

		// 尝试匹配用户词库
		answer = new WordMatch().getAnswerOnUser(problem);
		if (answer != null)
			return answer;

		// 尝试匹配标准句库
		answer = new WordMatch().getAnswerOnStand(problem);
		if (answer != null)
			return answer;

		//语境匹配
		answer = com.zxc.tell.bean.Theme.getValue(problem);
		if (answer != null)
			return answer;
		
		// 无法匹配
		answer = com.zxc.tell.bean.Tail.getValue();

		return answer;
	}

}

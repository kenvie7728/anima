package com.zxc.note.bean;

public class Note implements Comparable<Note> {

	private String title;
	private String content;
	private String writeTime;
	private String goalTime;
	private boolean remind;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}

	public String getGoalTime() {
		return goalTime;
	}

	public void setGoalTime(String goalTime) {
		this.goalTime = goalTime;
	}

	public boolean isRemind() {
		return remind;
	}

	public void setRemind(boolean remind) {
		this.remind = remind;
	}

	@Override
	public int compareTo(Note o) {
		return this.writeTime.compareTo(o.getWriteTime());
	}

}

package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Guestbook implements Serializable{
	private int wid;
	private int mid;
	private String content;
	private String answerContent;
	public Guestbook() {
		super();
	}
	public Guestbook(int wid, int mid, String content, String answerContent) {
		super();
		this.wid = wid;
		this.mid = mid;
		this.content = content;
		this.answerContent = answerContent;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	@Override
	public String toString() {
		return "Guestbook [answerContent=" + answerContent + ", content="
				+ content + ", mid=" + mid + ", wid=" + wid + "]";
	}
	
	
}

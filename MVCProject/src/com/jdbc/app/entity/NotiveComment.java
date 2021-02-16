package com.jdbc.app.entity;

import java.util.Date;

public class NotiveComment {

	private int id;
	private int mid;
	private String writerId;
	private String comment;
	private Date regDate;
	
	public NotiveComment() {
		
	}
	
	public NotiveComment(int id, int mid, String writerId, String comment, Date regDate) {
		super();
		this.id = id;
		this.mid = mid;
		this.writerId = writerId;
		this.comment = comment;
		this.regDate = regDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}

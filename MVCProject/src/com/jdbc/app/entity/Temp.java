package com.jdbc.app.entity;

public class Temp {

	String date;
	int temp;
	int locid;
	String writer;
	
	public Temp(String date, int temp, int locid, String writer) {
		
		this.date = date;
		this.temp = temp;
		this.locid = locid;
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getLocid() {
		return locid;
	}

	public void setLocid(int locid) {
		this.locid = locid;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}

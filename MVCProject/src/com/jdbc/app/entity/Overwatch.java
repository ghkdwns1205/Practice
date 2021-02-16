package com.jdbc.app.entity;

import java.util.Date;

public class Overwatch {
	
	String location;
	Date date;
	String name;
	String enemy;
	String content;
	String id;
	int pass;
	String name1;
	String email;
	String flag;
	int seq;
	
	public Overwatch(String location, Date date, String name, String enemy, String content) {
		this.location=location;
		this.date = date;
		this.name = name;
		this.enemy = enemy;
		this.content = content;
	}
	public Overwatch(String id, int pass, String name1, String email, String flag) {
		this.id = id;
		this.pass = pass;
		this.name1 = name1;
		this.email = email;
		this.flag = flag;
	}
	public Overwatch(String location, Date date, String id, String name, String enemy, String content, int seq) {
		this.location=location;
		this.date = date;
		this.name = name;
		this.enemy = enemy;
		this.content = content;
		this.id = id;
		this.seq = seq;
	}
	
	public Overwatch(String location) {
		this.location=location;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnemy() {
		return enemy;
	}
	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

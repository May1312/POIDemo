package com.helian.bean;

import java.util.Date;

public class User {

	public User() {
		super();
	}
	private String name;
	private Integer age;
	private Date time;
	
	public User(String name, Integer age, Date time) {
		super();
		this.name = name;
		this.age = age;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", time=" + time + "]";
	}
	
}

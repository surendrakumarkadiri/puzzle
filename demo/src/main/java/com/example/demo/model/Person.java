package com.example.demo.model;

public class Person {

	private String name;
	private String email;
	private String time;
	
	

	public Person() {
		super();
	}

	public Person(String name, String email, String time) {
		super();
		this.name = name;
		this.email = email;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

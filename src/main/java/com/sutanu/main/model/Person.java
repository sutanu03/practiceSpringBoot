package com.sutanu.main.model;

public class Person {

	private String name;
	private String email;
	private String pass;
	private String gender;
	private String city;

	public Person() {
		super();
	}
	
	public Person(String name, String email, String pass, String gender, String city) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.gender = gender;
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", pass=" + pass + ", gender=" + gender + ", city=" + city
				+ "]";
	}

}

package com.web.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "people")
public class People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="surname")
	private String surname;
	
	@Column(name ="age")
	private int age;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="img")
	private String imgUrl;
	
	@Column(name ="message")
	private String message;
	
	@Column(name = "birthday")
	private Date birthday;

	
	public People() {
		
	}


	public People(int id, String name, String surname, int age, String address, String imgUrl, String message, Date birthday) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.address = address;
		this.imgUrl = imgUrl;
		this.message = message;
		this.birthday = birthday;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	
	
	
	
}

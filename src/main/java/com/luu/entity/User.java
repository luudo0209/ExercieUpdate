package com.luu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
public class User {	
	@Id  
   	@GeneratedValue(strategy = GenerationType.AUTO)  
   	private int userId;  

   	@Column(unique = true)
   	private String userName;  

	@Column(name = "email", unique = true)
	private String email;  
	
	@Column  
	private String address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String email, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}  
	
	
		
}

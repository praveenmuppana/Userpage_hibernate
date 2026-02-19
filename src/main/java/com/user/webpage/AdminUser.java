package com.user.webpage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserAdmin")
public class AdminUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="adminName")
	private String adminName;
	@Column(name = "adminPassword")
	private String adminPassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminUser(int id, String adminName, String adminPassword) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	
}

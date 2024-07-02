package com.kspl.c2cpass;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class C2c {
	@Id
	private Long userId;
	private String visaType;
	private String name;
	private String mobileNo;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date visaExpDate;
	
	//Getters and Setters
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getVisaType() {
		return visaType;
	}
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getVisaExpDate() {
		return visaExpDate;
	}
	public void setVisaExpDate(Date visaExpDate) {
		this.visaExpDate = visaExpDate;
	}
	
	
}

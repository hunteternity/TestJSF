package com.jamari.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="peopleData")
public class testController {

	private String id_num="Q123456789";
	private java.util.Date date;
    private String radioBtn;
    private String householdNumber_1;
    private String householdNumber_2;
    private String householdName ;
    private java.util.Date birthday;
    private String address;
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getHouseholdName() {
		return householdName;
	}


	public void setHouseholdName(String householdName) {
		this.householdName = householdName;
	}


	public java.util.Date getBirthday() {
		return birthday;
	}


	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}


	public String getRadioBtn() {
		return radioBtn;
	}

	
	public void setRadioBtn(String radioBtn) {
		this.radioBtn = radioBtn;
	}


	public String getHouseholdNumber_1() {
		return householdNumber_1;
	}


	public void setHouseholdNumber_1(String householdNumber_1) {
		this.householdNumber_1 = householdNumber_1;
	}


	public String getHouseholdNumber_2() {
		return householdNumber_2;
	}


	public void setHouseholdNumber_2(String householdNumber_2) {
		this.householdNumber_2 = householdNumber_2;
	}
	
	
	public java.util.Date getDate() {
		return date;
	}


	public void setDate(java.util.Date date) {
		this.date = date;
	}


	public String getId_num() {
		return id_num;
	}


	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	



	
	
}

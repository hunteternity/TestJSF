package com.jamari.model;

public class Car {
	
	private String mId;
	private String mYear;
	private String mBrand;
	private String mColor;
	
	public Car(String id,String year,String brand,String color){
		this.mId = id;
		this.mYear = year;
		this.mBrand = brand;
		this.mColor = color;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmYear() {
		return mYear;
	}

	public void setmYear(String mYear) {
		this.mYear = mYear;
	}

	public String getmBrand() {
		return mBrand;
	}

	public void setmBrand(String mBrand) {
		this.mBrand = mBrand;
	}

	public String getmColor() {
		return mColor;
	}

	public void setmColor(String mColor) {
		this.mColor = mColor;
	}
	
	
	

}

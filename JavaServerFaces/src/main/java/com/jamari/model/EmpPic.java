package com.jamari.model;

import java.util.Date;

import org.primefaces.model.StreamedContent;

public class EmpPic {

	private int empno;
	
	private byte[] pic;

	public EmpPic(){
		super();
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	
	
}

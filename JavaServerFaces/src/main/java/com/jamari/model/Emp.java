package com.jamari.model;

import java.util.Date;

public class Emp {

	private int empno;
	
	private Double comm ;
	
	private String ename;
	
	private Date hiredate;
	
	private Double sal;
	
	private int deptno;
	
	private int jobno;

	private boolean editable;

	public Emp(){
		super();
	}
	
	public Emp(int empno, Double comm, String ename, Date hiredate, Double sal,
			int deptno, int jobno) {
		super();
		this.empno = empno;
		this.comm = comm;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
		this.jobno = jobno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getJobno() {
		return jobno;
	}

	public void setJobno(int jobno) {
		this.jobno = jobno;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}

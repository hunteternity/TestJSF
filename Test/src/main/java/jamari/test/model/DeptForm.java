package jamari.test.model;

import jamari.base.model.FormBean;
import jamari.entities.test.Dept;

public class DeptForm extends FormBean {
	
	private Integer deptno;
	
	private String dname;
	
	private String loc;

	
	
	public DeptForm() {
		super();
	}

	public DeptForm(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Dept toDept(){
		Dept dept = new Dept(deptno, dname, loc);
		return dept;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	
	
}

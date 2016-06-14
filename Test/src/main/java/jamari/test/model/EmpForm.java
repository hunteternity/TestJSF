package jamari.test.model;

import jamari.base.model.FormBean;
import jamari.entities.test.Emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmpForm extends FormBean {
	
	private Integer empno;
	
	private String ename;
	
	private int jobno;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date hiredate;
	
	private Double sal;
	
	private Double comm;
	
	private int deptno;

	public EmpForm() {
		super();
	}

	public EmpForm(Emp emp) {
		empno = emp.getEmpno();
		ename = emp.getEname();
		jobno = emp.getJobno().getJobno();
		hiredate = emp.getHiredate();
		sal = emp.getSal();
		comm = emp.getComm();
		deptno = emp.getDeptno().getDeptno();
	}
	
	public Emp toEmp() {
		Emp emp = new Emp(empno, ename, null, hiredate, sal, comm, null);
		return emp;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getJobno() {
		return jobno;
	}

	public void setJobno(int	 jobno) {
		this.jobno = jobno;
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

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}

package jamari.entities.test;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="getAllEmp", query="from Emp where sal > 500")
@Table(name = "Emp")
public class Emp implements Serializable {

	private static final long serialVersionUID = -22975200295398679L;
	
	@Id
	@GeneratedValue(generator="empSeq")
    @SequenceGenerator(name="empSeq", sequenceName="emp_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "empno")
	private Integer empno;
	
	@Column(name = "ename")
	private String ename;
	
	@JoinColumn(name = "jobno")
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Jobno jobno;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "hiredate")
	private Date hiredate;
	
	@Column(name = "sal")
	private Double sal;
	
	@Column(name = "comm")
	private Double comm;
	
	@JoinColumn(name = "deptno")
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Dept deptno;
	
	public Emp() {
		super();
	}
	
	public Emp(Integer empno, String ename, Jobno jobno, Date hiredate,
			Double sal, Double comm, Dept deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.jobno = jobno;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
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

	public Jobno getJobno() {
		return jobno;
	}

	public void setJobno(Jobno jobno) {
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

	public Dept getDeptno() {
		return deptno;
	}

	public void setDeptno(Dept deptno) {
		this.deptno = deptno;
	}
	
}

package jamari.entities.test;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Dept")
public class Dept implements Serializable {

	private static final long serialVersionUID = 6449954794123343302L;

	@Id
    @GeneratedValue(generator="deptSeq")
    @SequenceGenerator(name="deptSeq", sequenceName="dept_seq", initialValue = 10, allocationSize = 10)
	@Column(name = "deptno")
	private Integer deptno;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deptno", orphanRemoval = true)
	private Set<Emp> emps;
	
	@Column(name = "dname")
	private String dname;
	
	@Column(name = "loc")
	private String loc;
	
	public Dept() {
		super();
	}

	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
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

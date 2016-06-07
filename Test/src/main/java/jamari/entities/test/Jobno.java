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
@Table(name = "Job")
public class Jobno implements Serializable {

	private static final long serialVersionUID = 8229423269534151724L;

	@Id
	@GeneratedValue(generator="jobSeq")
    @SequenceGenerator(name="jobSeq", sequenceName="job_seq", initialValue = 10, allocationSize = 10)
	@Column(name = "jobno")
	private Integer jobno;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobno", orphanRemoval = true)
	private Set<Emp> emps;
	
	@Column(name = "job_title")
	private String job_title;
	
	@Column(name = "min_salary")
	private Double min_salary;
	
	@Column(name = "max_salary")
	private Double max_salary;

	public Jobno(){
		super();
	}
	
	public Jobno(Integer jobno, String job_title, Double min_salary,
			Double max_salary) {
		super();
		this.jobno = jobno;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public Integer getJobno() {
		return jobno;
	}

	public void setJobno(Integer jobno) {
		this.jobno = jobno;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public Double getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(Double min_salary) {
		this.min_salary = min_salary;
	}

	public Double getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(Double max_salary) {
		this.max_salary = max_salary;
	}
	
}

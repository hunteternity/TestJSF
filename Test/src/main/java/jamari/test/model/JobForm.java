package jamari.test.model;

import jamari.base.model.FormBean;
import jamari.entities.test.Jobno;

public class JobForm extends FormBean {
	
	private Integer jobno;
	
	private String job_title;
	
	private Double min_salary;
	
	private Double max_salary;

	
	public Jobno toJob(){
		Jobno job = new Jobno(jobno, job_title, min_salary,max_salary);
		return job;
	}
	
	public JobForm() {
		super();
	}

	public JobForm(Integer jobno, String job_title, Double min_salary,
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

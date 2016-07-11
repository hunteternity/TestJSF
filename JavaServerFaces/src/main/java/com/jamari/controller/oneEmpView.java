package com.jamari.controller;
	
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name="oneEmpCon")
@RequestScoped
public class oneEmpView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EmpServiceImpl empSvc;
	
	@ManagedProperty(value="#{empDTO}") 
	private Emp emp;
	
	public String saveAction() {
		empSvc = new EmpServiceImpl();
		empSvc.updateByEmpNo(emp.getEmpno(), emp.getEname());
		PageController p = new PageController();
		p.empListReflash();
//		return null;
		return "/start?faces-redirect=true";
	}
	
	
	public void updateOneEmp(int empno){
		empSvc = new EmpServiceImpl();
		this.emp = empSvc.getByEmpNo(empno);
	}
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
}

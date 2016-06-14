package com.jamari.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "empData")
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Emp> empList = getAll();
	EmpServiceImpl empSvc;
	String newEmp;

	public String getNewEmp() {
		return newEmp;
	}

	public void setNewEmp(String newEmp) {
		this.newEmp = newEmp;
	}

	private List<Emp> getAll() {
		empSvc = new EmpServiceImpl();
		return empSvc.getAll();
	}

	public String processPage1() {
		return "success";
	}

	public String processPage2() {
		return "success";
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public String editAction(Emp emp) {
		emp.setEditable(true);
		return null;
	}

	public String saveAction() {
		// get all existing value but set "editable" to false
		for (Emp emp : empList) {
			if (emp.getEditable()) {
				empSvc.updateByEmpNo(emp.getEmpno(), emp.getEname());
				emp.setEditable(false);
			}
		}
		// return to current page
		return null;
	}
	
	public String delete(Emp emp){
		empSvc.deleteByEmpNo(emp.getEmpno());
		empList = getAll();
		return null;
	}
	
	public String insertAction(){
		empSvc.insertByEname(newEmp); 
		empList = getAll();
		newEmp = "";
		return null;
	}
}
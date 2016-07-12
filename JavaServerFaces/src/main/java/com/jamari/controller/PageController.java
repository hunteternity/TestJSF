package com.jamari.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "empData")
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Emp> empList = getAll();
	EmpServiceImpl empSvc;
	private String newEmp;
	private String editEmp;


	public String getNewEmp() {
		return newEmp;
	}

	public void setNewEmp(String newEmp) {
		this.newEmp = newEmp;
	}
	
	public String getEditEmp() {
		return editEmp;
	}

	public void setEditEmp(String editEmp) {
		this.editEmp = editEmp;
	}

	public List<Emp> getAll() {
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
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
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

	public String delete(Emp emp) {
		empSvc.deleteByEmpNo(emp.getEmpno());
		empListReflash();
		return null;
	}

	public String insertAction() {
		empSvc.insertByEname(newEmp);
		empListReflash();
		newEmp = "";
		return null;

	}

	public void empListReflash(){
		Boolean check = true;
		for (Emp emp : empList) {
			if (emp.getEditable()) {
				check = false;
				break;
			}
		}
		if(check){
			this.empList = getAll();
		}
	}
}

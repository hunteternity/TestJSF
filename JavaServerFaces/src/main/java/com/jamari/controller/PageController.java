package com.jamari.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

	List<Emp> empList = getAll();
	EmpServiceImpl empSvc;
	String newEmp;
	List<String> c1 =categories1();
	List<String> c2 =categories2();
	
	private String level1Value;
	private List<SelectItem> level1 = getLevel01Items( );
	private Map<String,List<SelectItem>> level02 =getLevel02Items();
	
	public List<String> getC1(){
		return c1;
	}
	public List<String> getC2(){
		return c2;
	}
	
	public String getNewEmp() {
		return newEmp;
	}
	
	public List<String> categories1(){
		List<String> cate = new ArrayList<String>();
		cate.add("a");
		cate.add("b");
		cate.add("c");
		return cate;
	}
	public List<String> categories2(){
		List<String> cate = new ArrayList<String>();
		cate.add("A");
		cate.add("B");
		cate.add("C");
		return cate;
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
	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getRandomItems(String itemName){
		List<SelectItem> result =new ArrayList<SelectItem> ();
		for(int i =0 ; i<10 ;i++){
			result.add(new SelectItem(itemName));
		}
		return result ;
	}
	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getLevel01Items( ){
		List<SelectItem> result =new ArrayList<SelectItem> ();
		result.add(new SelectItem("A"));
		result.add(new SelectItem("B"));
		result.add(new SelectItem("C"));
		return result ;
	}
	public Map<String,List<SelectItem>> getLevel02Items(){
		Map<String,List<SelectItem>>  result =new HashMap<String,List<SelectItem>> ();
		result.put("A", getRandomItems("A"));
		result.put("B", getRandomItems("B"));
		result.put("C", getRandomItems("C"));
		return result;
	}
	public void valueChangeMethod(ValueChangeEvent e){
		 System.out.println(e.getNewValue().toString());
		 
	}
	public List<SelectItem> getLevel1() {
		return level1;
	}
	public void setLevel1(List<SelectItem> level1) {
		this.level1 = level1;
	}
	public Map<String, List<SelectItem>> getLevel02() {
		return level02;
	}
	public void setLevel02(Map<String, List<SelectItem>> level02) {
		this.level02 = level02;
	}
	public String getLevel1Value() {
		return level1Value;
	}
	public void setLevel1Value(String level1Value) {
		this.level1Value = level1Value;
	}
	
}

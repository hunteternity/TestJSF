package com.jamari.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.jamari.model.Emp;

@ManagedBean(name = "selectItemCon")
@ViewScoped
public class SelectItemCon implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean isLevel02 = false;
	private Boolean isLevel03 = false;

	public Boolean getIsLevel02() {
		return isLevel02;
	}

	public void setIsLevel02(Boolean isLevel02) {
		this.isLevel02 = isLevel02;
	}

	public Boolean getIsLevel03() {
		return isLevel03;
	}

	public void setIsLevel03(Boolean isLevel03) {
		this.isLevel03 = isLevel03;
	}

	private List<SelectItem> level1 = getLevel01Items();
	private Map<String, List<SelectItem>> level02 = getLevel02Items();
	private Map<String, List<SelectItem>> level03 = getLevel03Items();
	private String level1Value = level1.get(0).getValue().toString();
	private String level2Value = level02.get(level1Value).get(0).getValue()
			.toString();


	public String processPage1() {
		return "success";
	}

	public String processPage2() {
		return "success";
	}

	public String editAction(Emp emp) {
		emp.setEditable(true);
		return null;
	}


	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getRandomItems(String itemName) {
		List<SelectItem> result = new ArrayList<SelectItem>();
		if ("A".equals(itemName)) {
			result.add(new SelectItem("Apple"));
			result.add(new SelectItem("America"));
		} else if ("B".equals(itemName)) {
			result.add(new SelectItem("Business"));
		}
		return result;
	}

	public List<SelectItem> getRandomItems02(String itemName) {
		List<SelectItem> result = new ArrayList<SelectItem>();
		if ("Apple".equals(itemName)) {
			result.add(new SelectItem("Apple juice"));
			result.add(new SelectItem("Apple cake"));
			result.add(new SelectItem("Apple Iphone"));
		} else if ("America".equals(itemName)) {
			result.add(new SelectItem("America people"));
		} else if ("Business".equals(itemName)) {
			result.add(new SelectItem("Business man"));
			result.add(new SelectItem("Business model"));
		}
		return result;
	}

	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getLevel01Items() {
		List<SelectItem> result = new ArrayList<SelectItem>();
		result.add(new SelectItem("A"));
		result.add(new SelectItem("B"));
		return result;
	}

	public Map<String, List<SelectItem>> getLevel02Items() {
		Map<String, List<SelectItem>> result = new HashMap<String, List<SelectItem>>();
		result.put("A", getRandomItems("A"));
		result.put("B", getRandomItems("B"));
		return result;
	}

	public Map<String, List<SelectItem>> getLevel03Items() {
		Map<String, List<SelectItem>> result = new HashMap<String, List<SelectItem>>();
		result.put("Apple", getRandomItems02("Apple"));
		result.put("America", getRandomItems02("America"));
		result.put("Business", getRandomItems02("Business"));
		return result;
	}

	public void valueChangeMethod(ValueChangeEvent e) {
		this.level1Value = e.getNewValue().toString();
		this.level2Value = level02.get(this.level1Value).get(0).getValue()
				.toString();
		this.isLevel02 = true;
		
		if(level02.get(this.level1Value).size()==1){
			this.isLevel03 = true;
		}else{
			this.isLevel03 = false;
		}
	}

	public void valueChangeMethod02(ValueChangeEvent e) {
		System.out.println("change111");
		this.level2Value = e.getNewValue().toString();
		this.isLevel03 = true;
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

	public String getLevel1Value() {
		return level1Value;
	}

	public void setLevel1Value(String level1Value) {
		this.level1Value = level1Value;
	}

	public Map<String, List<SelectItem>> getLevel03() {
		return level03;
	}

	public String getLevel2Value() {
		return level2Value;
	}

	public void setLevel2Value(String level2Value) {
		this.level2Value = level2Value;
	}
	
}

package com.jamari.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import com.jamari.model.Color;
import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "empData")
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Emp> empList = getAll();
	EmpServiceImpl empSvc;
	String newEmp;
	List<String> c1 = categories1();
	List<String> c2 = categories2();

	private String level1Value ="A";
	private List<SelectItem> level1 = getLevel01Items();
	private String level2Value ;
	private Map<String, List<SelectItem>> level02 = getLevel02Items();
	

	public List<String> getC1() {
		return c1;
	}

	public List<String> getC2() {
		return c2;
	}

	public String getNewEmp() {
		return newEmp;
	}

	public List<String> categories1() {
		List<String> cate = new ArrayList<String>();
		cate.add("a");
		cate.add("b");
		cate.add("c");
		return cate;
	}

	public List<String> categories2() {
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

	public String delete(Emp emp) {
		empSvc.deleteByEmpNo(emp.getEmpno());
		empList = getAll();
		return null;
	}

	public String insertAction() {
		empSvc.insertByEname(newEmp);
		empList = getAll();
		newEmp = "";
		return null;
	}

	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getRandomItems(String itemName) {
		List<SelectItem> result = new ArrayList<SelectItem>();
		for (int i = 0; i < 10; i++) {
			result.add(new SelectItem(itemName));
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
		result.add(new SelectItem("C"));
		return result;
	}

	public Map<String, List<SelectItem>> getLevel02Items() {
		Map<String, List<SelectItem>> result = new HashMap<String, List<SelectItem>>();
		
		List<SelectItem> result1 = new ArrayList<SelectItem>();
		List<SelectItem> result2 = new ArrayList<SelectItem>();
		List<SelectItem> result3 = new ArrayList<SelectItem>();
		
		SelectItemGroup group1 = new SelectItemGroup("Group 1");
		SelectItemGroup group2 = new SelectItemGroup("Group 2");
		SelectItemGroup group3 = new SelectItemGroup("Group 3");
		
		/*SelectItemGroup group11 = new SelectItemGroup("Group 1.1");
		SelectItemGroup group12 = new SelectItemGroup("Group 1.2");*/
		SelectItem option11 = new SelectItem("Option A.1", "Option A.1");
		SelectItem option12 = new SelectItem("Option A.2", "Option A.2");
		
		/*SelectItemGroup group21 = new SelectItemGroup("Group 2.1");*/
		SelectItem option21 = new SelectItem("Option B.1", "Option B.1");
		
		SelectItem option31 = new SelectItem("Option C.1", "Option C.1");
		SelectItem option32 = new SelectItem("Option C.2", "Option C.2");
		SelectItem option33 = new SelectItem("Option C.3", "Option C.3");
		SelectItem option34 = new SelectItem("Option C.4", "Option C.4");
		
		/*SelectItem option111 = new SelectItem("Option 1.1.1");
		SelectItem option112 = new SelectItem("Option 1.1.2");
		group11.setSelectItems(new SelectItem[] { option111, option112 });
		
		SelectItem option121 = new SelectItem("Option 1.2.1", "Option 1.2.1");
		SelectItem option122 = new SelectItem("Option 1.2.2", "Option 1.2.2");
		SelectItem option123 = new SelectItem("Option 1.2.3", "Option 1.2.3");
		group12.setSelectItems(new SelectItem[] { option121, option122,
				option123 });*/
		
		/*group1.setSelectItems(new SelectItem[] { group11,group12 });
		group2.setSelectItems(new SelectItem[] { group21 });
		group3.setSelectItems(new SelectItem[] { option31, option32, option33,option34 });*/
		
		result1.add(option11);
		result1.add(option12);
		result2.add(option21);
		result3.add(option31);
		result3.add(option32);
		result3.add(option33);
		result3.add(option34);
		
		result.put("A", result1);
		result.put("B", result2);
		result.put("C", result3);
		return result;
	}
	
	

	public void valueChangeMethod(ValueChangeEvent e) {
		
		/*System.out.println("----valueChangeMethod ="+e.getNewValue().toString());*/
		level2Value = null;

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
	
	public String getLevel2Value() {
		return level2Value;
	}

	public void setLevel2Value(String level2Value) {
		this.level2Value = level2Value;
	}

	/*protected String color1, color2, color3, color4;

	private String[] colorNames = { "red", "orange", "yellow", "green", "blue",
			"purple" };
	private List<String> colorValues = Arrays.asList("#ff0000", "#ffa500",
			"#ffff00", "#008000", "#0000ff", "#800080");
	private Map<String, String> colorMap = new LinkedHashMap<>();
	private List<Color> colorList = new ArrayList<>();

	
	
	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		System.out.println("----color1 = "+color1);
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getColor3() {
		return color3;
	}

	public void setColor3(String color3) {
		this.color3 = color3;
	}

	public String getColor4() {
		return color4;
	}

	public void setColor4(String color4) {
		this.color4 = color4;
	}

	
	
	public String[] getColorNames() {
		return colorNames;
	}

	public List<String> getColorValues() {
		return colorValues;
	}

	public Map<String, String> getColorMap() {
		return colorMap;
	}

	public List<Color> getColorList() {
		return colorList;
	}

	public void ColorOptions() {
		for (int i = 0; i < colorNames.length; i++) {
			String colorName = colorNames[i];
			String colorValue = colorValues.get(i);
			colorMap.put(colorName, colorValue);
			colorList.add(new Color(colorName, colorValue));
		}
	}*/

}

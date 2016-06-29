package com.jamari.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.jamari.model.Dept;
import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.DeptServiceImpl;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "page2Con")
@SessionScoped
public class Page2Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Emp> empList = getAllEmp();
	List<Dept> deptList = getAllDept();
	DeptServiceImpl deptSvc;
	EmpServiceImpl empSvc;
	Boolean isLevel02 = false;
	Boolean isLevel03 = false;
	private StreamedContent imgFromDB;

	
	private List<SelectItem> depts = getDeptsItems();
	private Map<String, List<SelectItem>> emps = getEmpsItems();
	private String deptValue = depts.get(0).getValue().toString();
	private Part file;
	private int imgno;

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

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

	public int getImgno() {
		return imgno;
	}

	public void setImgno(int imgno) {
		this.imgno = imgno;
	}

	public List<SelectItem> getDepts() {
		return depts;
	}

	public void setDepts(List<SelectItem> depts) {
		this.depts = depts;
	}

	public Map<String, List<SelectItem>> getEmps() {
		return emps;
	}

	public void setEmps(Map<String, List<SelectItem>> emps) {
		this.emps = emps;
	}

	private List<Emp> getAllEmp() {
		empSvc = new EmpServiceImpl();
		return empSvc.getAll();
	}

	private List<Dept> getAllDept() {
		deptSvc = new DeptServiceImpl();
		return deptSvc.getAll();
	}

	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getEmpsEnames(int deptno) {
		List<SelectItem> result = new ArrayList<SelectItem>();
		List<Emp> emps = empSvc.getByDeptNo(deptno);
		for (int i = 0; i < emps.size(); i++) {
			result.add(new SelectItem(emps.get(i).getEmpno(), emps.get(i)
					.getEname()));
		}
		return result;
	}

	/***
	 * jsf 1.0 寫法
	 * **/
	public List<SelectItem> getDeptsItems() {
		List<SelectItem> result = new ArrayList<SelectItem>();

		for (int i = 0; i < deptList.size(); i++) {
			result.add(new SelectItem(deptList.get(i).getDeptno(), deptList
					.get(i).getDname()));
		}
		return result;
	}

	public Map<String, List<SelectItem>> getEmpsItems() {
		Map<String, List<SelectItem>> result = new HashMap<String, List<SelectItem>>();
		for (Dept dept : deptList) {
			result.put(dept.getDeptno() + "", getEmpsEnames(dept.getDeptno()));
		}
		return result;
	}

	public void valueChangeMethod(ValueChangeEvent e) {
		this.deptValue = e.getNewValue().toString();
		int beanSize = empSvc.getByDeptNo(Integer.parseInt(this.deptValue))
				.size();
		if (beanSize > 0) {
			this.imgno = empSvc.getByDeptNo(Integer.parseInt(this.deptValue))
					.get(0).getEmpno();
		}
		this.isLevel02 = true;
		this.isLevel03 = false;

	}

	public void valueChangeMethod02(ValueChangeEvent e) throws IOException {
		String empno = e.getNewValue().toString();
		for (Emp emp : empList) {
			if ((emp.getEmpno() + "").equals(empno)) {
				this.imgno = emp.getEmpno();
			}
		}
		this.isLevel03 = true;
		setImgFromDB(getImageFromDB());
	}

	public List<SelectItem> getDept() {
		return depts;
	}

	public void setDept(List<SelectItem> dept) {
		this.depts = dept;
	}

	public String getDeptValue() {
		return deptValue;
	}

	public void setDeptValue(String deptValue) {
		this.deptValue = deptValue;
	}

	public void upload(int empno) {
		try {
			java.io.InputStream in = this.file.getInputStream();
			byte[] img = new byte[in.available()];
			in.read(img);
			empSvc.updateImgByEmpNo(empno, img);
		} catch (IOException e) {
			// Error handling
		}
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	/***
	 *	level02 value changed 
	 *	get imgno return pic_value
	 * **/
	public StreamedContent getImageFromDB() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte[] image = null;
			try {
				image = new EmpServiceImpl().getByEmpNo(this.imgno).getPic();
			} catch (Exception e) { 
				e.printStackTrace();
			}
			return new DefaultStreamedContent(new ByteArrayInputStream(image),
					"image/png");

		}
	}

	public StreamedContent getImgFromDB() {
		return imgFromDB;
	}

	public void setImgFromDB(StreamedContent imgFromDB) {
		this.imgFromDB = imgFromDB;
	}

	/***
	 *	param : empno 
	 *	from frontend image request
	 * **/
	public StreamedContent getPic() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		empSvc = new EmpServiceImpl();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			int empno = Integer.parseInt(context.getExternalContext()
					.getRequestParameterMap().get("empno"));
			byte[] pic = empSvc.getByEmpNo(empno).getPic();
			return new DefaultStreamedContent(new ByteArrayInputStream(
					pic));
		}
	}
}

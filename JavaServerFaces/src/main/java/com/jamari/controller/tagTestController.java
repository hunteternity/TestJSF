package com.jamari.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.jamari.model.Emp;
import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "tagTestCon")
@SessionScoped
public class tagTestController implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Emp> empList = getAllEmp();
	
	EmpServiceImpl empSvc;
	
	private String radioValue;
	
	private String radioValueDefault ;
	
	private int activeIndexValue;
	
	
	
	private List<Emp> getAllEmp() {
		empSvc = new EmpServiceImpl();
		return empSvc.getAll();
	}
	
	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	public void valueChange(ValueChangeEvent e){
		this.activeIndexValue = Integer.parseInt(e.getNewValue().toString()) - 1;
	}
	public void valueChangeAJAX(){
		this.activeIndexValue = Integer.parseInt(this.radioValue) - 1;
	}
	public void valueChangeDefault(ValueChangeEvent e){
		System.err.println("oldValue:"+e.getOldValue());
		System.err.println("newValue:"+e.getNewValue());
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

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	public int getActiveIndexValue() {
		return activeIndexValue;
	}

	public void setActiveIndexValue(int activeIndexValue) {
		this.activeIndexValue = activeIndexValue;
	}

	public String getRadioValueDefault() {
		return radioValueDefault;
	}

	public void setRadioValueDefault(String radioValueDefault) {
		this.radioValueDefault = radioValueDefault;
	}
	
}

package jamari.test.action;
 
import jamari.entities.test.Emp;
import jamari.test.service.impl.EmpServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public String processPage1(){
		return "success";
	}
	
	public String processPage2(){
		return "success";
	}
	
	public List<Emp> emp(){
		System.out.println("111");
		List<Emp> list = new ArrayList<Emp>();
		EmpServiceImpl empSvc = new EmpServiceImpl();
		list = empSvc.list();
		return list;
	}
	
	public void getEdit(Emp emp){
		System.out.println("Empno:"+emp.getEmpno());
//		List<Emp> list = new ArrayList<Emp>();
//		EmpServiceImpl empSvc = new EmpServiceImpl();
//		list = empSvc.getAll();
	}
	
}
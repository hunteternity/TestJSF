package jamari.test.action;
 
import jamari.entities.test.Emp;
import jamari.test.service.EmpService;
import jamari.test.service.impl.EmpServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.cdisource.springintegration.Spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@ManagedBean(name = "empData", eager = true) 
//@Named(value="empData")
//@RequestScoped
@Component 
@SessionScoped
public class PageCon implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Autowired
	private EmpService empSvc1;
	
	@Inject
	@Spring(name = "empServiceImpl")
	private EmpService empSvc;
	
	public List<Emp> emp(){
//		EmpServiceImpl empSvc = new EmpServiceImpl();
		List<Emp> list = empSvc.list();
		return list;
	}
	
//	public void edit(Emp item){
//		System.out.println("1111");
////		List<Emp> list = new ArrayList<Emp>();
////		EmpServiceImpl empSvc = new EmpServiceImpl();
////		list = empSvc.list();
//	}
	
}
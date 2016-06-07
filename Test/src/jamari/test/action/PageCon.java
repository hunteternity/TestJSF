package jamari.test.action;
 
import jamari.entities.test.Emp;
import jamari.test.service.impl.EmpServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
 
@ManagedBean(name = "empData", eager = true)
@SessionScoped
public class PageCon implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject
	List<Emp> list;
	
	public List<Emp> emp(){
		EmpServiceImpl empSvc = new EmpServiceImpl();
		list = empSvc.list();
		return list;
	}
	
//	public void edit(Emp item){
//		System.out.println("1111");
////		List<Emp> list = new ArrayList<Emp>();
////		EmpServiceImpl empSvc = new EmpServiceImpl();
////		list = empSvc.list();
//	}
	
}
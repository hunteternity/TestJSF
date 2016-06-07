package jamari.test.action;

import jamari.entities.test.Dept;
import jamari.entities.test.Emp;
import jamari.entities.test.Jobno;
import jamari.test.service.DeptService;
import jamari.test.service.EmpService;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private EmpService empSvc;
	
	@Autowired
	private DeptService deptSvc;
	
	@RequestMapping(value = "/selectByDept/{deptno}")
	public List<Emp> selectByDept(@PathVariable int deptno) {
		return empSvc.selectByDept(deptno);
	}
	
	@RequestMapping(value = "/allEmp")
	public List<Emp> allEmp() {
		return empSvc.list("empno",true);
	}
	
	@RequestMapping(value = "/namedQuery")
	public List<Emp> namedQuery() {
		return empSvc.namedQuery();
	}
	
	@RequestMapping(value = "/selectByEmpNo/{empno}")
	public Emp selectByEmpNo(@PathVariable int empno) {
		return empSvc.selectByEmpNo(empno);
	}
	
	@RequestMapping(value = "/selectHQL")
	public List<Emp> selectHQL() {
		return empSvc.selectHQL();
	}
	
	@RequestMapping(value = "/create/{ename},{jname}")
	public List<Emp> insertByEname(@PathVariable String ename,@PathVariable String jname) throws UnsupportedEncodingException{
		Dept dept = new Dept(null, "CHT","FFS");
		Jobno job = new Jobno(null,jname,1000d,100d);
		Calendar c = Calendar.getInstance();
		Emp emp = new Emp(null,ename,job,c.getTime(),40000d,8000d,dept);
		empSvc.save(emp);
		return empSvc.list();
	}
	
	@RequestMapping(value = "/create")
	public List<Emp> insert() {
		Dept dept = new Dept(null, "iisi", "financial");
		Jobno job = new Jobno(1,"測試員",1000.0,100.0);
		Calendar c = Calendar.getInstance();
		Emp emp = new Emp(null, "測試員1", job, c.getTime(), 40000d, 8000d, dept);
		empSvc.create(emp); // emp cascade insert dept
		return empSvc.list();
	}
	
	@RequestMapping(value = "/deleteByEmpNo/{empno}")
	public List<Emp> deleteEmp(@PathVariable int empno) {
		Emp emp = new Emp();
		emp.setEmpno(empno); // delete empno
		empSvc.delete(emp);
		return empSvc.list();
	}
	
	@RequestMapping(value = "/deleteDept")
	public List<Emp> deleteDept() {
		Dept dept = new Dept();
		dept.setDeptno(30); // delete deptno = 30
		deptSvc.delete(dept);
		return empSvc.list();
	}
	
	@RequestMapping(value = "/updateByEmpNo/{empno},{ename}")
	public List<Emp> updeteEmp(@PathVariable int empno,@PathVariable String ename) {
		Emp emp = empSvc.find(Emp.class, empno);
		emp.setEname(ename);
		empSvc.save(emp);
		return empSvc.list();
	}
	
	@RequestMapping(value = "/updateDept")
	public List<Emp> updeteDept() {
		Dept dept = deptSvc.find(Dept.class, 20);
		dept.setLoc("TTT");
		dept.setDname("QQQ");
		deptSvc.save(dept);
		return empSvc.list();
	}
	
}

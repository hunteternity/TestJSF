package jamari.test.service;

import jamari.base.service.IService;
import jamari.entities.test.Emp;

import java.util.List;

public interface EmpService extends IService<Emp> {

	List<Emp> namedQuery();	
	
	Emp selectByEmpNo(int empno);
	
	List<Emp> selectByDept(int deptno);
	
	List<Emp> selectByEname(String ename);
	
	List<Emp> selectHQL();
}

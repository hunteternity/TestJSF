package jamari.test.dao;

import jamari.base.dao.IDao;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;

import java.util.List;

public interface EmpDao extends IDao<Emp>{

	/**
	 * select * <br>
	 * where FK = ?
	 * @param dept FK
	 */
	List<Emp> selectByDept(int deptno);
	
	List<Emp> selectByEname(String ename);
	
	Emp selectByEmpNo(int empno);
	
	List<Emp> namedQuery();
	
	List<Emp> selectHQL();
	
}

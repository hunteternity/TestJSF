package jamari.test.dao;

import java.util.List;

import jamari.base.dao.IDao;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;

public interface DeptDao extends IDao<Dept> {
	Dept selectByDept(int deptno);
}

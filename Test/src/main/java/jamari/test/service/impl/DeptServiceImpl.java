package jamari.test.service.impl;

import java.util.List;

import jamari.base.service.impl.BaseService;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;
import jamari.test.dao.DeptDao;
import jamari.test.dao.EmpDao;
import jamari.test.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends BaseService<Dept> implements DeptService {

	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public void delete(Dept bean) {
		Dept dept = deptDao.find(Dept.class, bean.getDeptno());
		for (Emp emp : dept.getEmps()) {
			empDao.delete(emp);
		}
		super.delete(dept);
	}

	@Override
	public Dept selectByDept(int deptno) {
		
		return deptDao.selectByDept(deptno);
	}
	
	
}

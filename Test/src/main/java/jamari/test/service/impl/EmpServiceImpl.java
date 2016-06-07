package jamari.test.service.impl;

import jamari.base.service.impl.BaseService;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;
import jamari.test.dao.EmpDao;
import jamari.test.service.EmpService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends BaseService<Emp> implements EmpService {

	@Autowired
	private EmpDao dao;
	
	@Override
	public Emp selectByEmpNo(int empno) {
		return dao.selectByEmpNo(empno);
	}
	
	@Override
	public List<Emp> selectByDept(int deptno) {
		return dao.selectByDept(deptno);
	}
	
	@Override
	public List<Emp> selectByEname(String ename) {
		return dao.selectByEname(ename);
	}

	@Override
	public List<Emp> namedQuery() {
		
		return dao.namedQuery();
	}

	@Override
	public List<Emp> selectHQL() {
		return dao.selectHQL();
	}

}

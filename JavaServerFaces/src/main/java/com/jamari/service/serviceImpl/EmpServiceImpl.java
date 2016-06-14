package com.jamari.service.serviceImpl;

import java.util.List;
 
import com.jamari.dao.EmpJDBCDAOH2;
import com.jamari.dao.IEmpJDBCDAO;
import com.jamari.model.Emp;
import com.jamari.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private IEmpJDBCDAO dao;
	
	public EmpServiceImpl(){
		dao = new EmpJDBCDAOH2();
	}
	
	public List<Emp> getAll(){
		return dao.getAll();
	}
	
	public int updateByEmpNo(int empno,String ename){
		return dao.updateByEmpNo(empno, ename);
	}

	public int deleteByEmpNo(int empno) {
		return dao.deleteByEmpNo(empno); 
		
	}

	public int insertByEname(String newEmp) {
		return dao.insertByEname(newEmp);
			
	}
	
}

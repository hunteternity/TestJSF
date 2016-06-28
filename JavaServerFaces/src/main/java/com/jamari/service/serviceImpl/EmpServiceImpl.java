package com.jamari.service.serviceImpl;

import java.util.List;

import com.jamari.dao.daoImpl.EmpJDBCDAOH2;
import com.jamari.model.Dept;
import com.jamari.model.Emp;
import com.jamari.service.EmpService;

public class EmpServiceImpl implements EmpService {
//	private EmpJDBCDAO dao;
	private EmpJDBCDAOH2 dao;
	
	public EmpServiceImpl(){
//		dao = new EmpJDBCDAO();
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

	@Override
	public List<Emp> getByDeptNo(int deptno) {
		return dao.getByDeptNo(deptno);
	}
	
	@Override
	public int updateImgByEmpNo(int empno,byte[] img) {
		return dao.updateImgByEmpNo(empno,img);
	}

	@Override
	public Emp getByEmpNo(int empno) {
		return dao.getByEmpNo(empno);
	}

	@Override
	public List<Dept> getAllDept() {
		return dao.getAllDept();
	}
	
}

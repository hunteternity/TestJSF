package com.jamari.service.serviceImpl;

import java.util.List;

import com.jamari.dao.daoImpl.EmpJDBCDAO;
import com.jamari.model.Emp;
import com.jamari.model.EmpPic;
import com.jamari.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpJDBCDAO dao;
	
	public EmpServiceImpl(){
		dao = new EmpJDBCDAO();
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
	public EmpPic getByEmpNo(int empno) {
		return dao.getByEmpNo(empno);
	}
	
	@Override
	public int updateImgByEmpNo(int empno,byte[] img) {
		return dao.updateImgByEmpNo(empno,img);
	}
	
}

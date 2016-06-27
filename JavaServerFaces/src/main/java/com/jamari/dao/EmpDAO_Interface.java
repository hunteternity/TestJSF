package com.jamari.dao;

import java.util.List;

import com.jamari.model.Dept;
import com.jamari.model.Emp;

public interface EmpDAO_Interface {

	int updateByEmpNo(int empno, String ename);

	int deleteByEmpNo(int empNo);

	int insertByEname(String ename);

	List<Emp> getAll();
	
	List<Emp> getByDeptNo(int deptno);

	int updateImgByEmpNo(int empno,byte[] img);
	
	Emp getByEmpNo(int empno);
	
	List<Dept> getAllDept();
}

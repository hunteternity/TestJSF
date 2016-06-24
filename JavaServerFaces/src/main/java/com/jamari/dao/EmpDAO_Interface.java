package com.jamari.dao;

import java.util.List;

import com.jamari.model.Emp;
import com.jamari.model.EmpPic;

public interface EmpDAO_Interface {

	int updateByEmpNo(int empno, String ename);

	int deleteByEmpNo(int empNo);

	int insertByEname(String ename);

	List<Emp> getAll();
	
	List<Emp> getByDeptNo(int deptno);

	EmpPic getByEmpNo(int empno);

	int updateImgByEmpNo(int empno,byte[] img);
}

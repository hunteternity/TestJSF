package com.jamari.service;

import java.util.List;

import com.jamari.model.Emp;
import com.jamari.model.EmpPic;


public interface EmpService {
	
	public List<Emp> getAll();

	public int updateByEmpNo(int empno, String ename);
	
	public int deleteByEmpNo(int empno); 
	
	public int insertByEname(String ename);
	
	public List<Emp> getByDeptNo(int deptno);
	
	public EmpPic getByEmpNo(int empno);
	
	public int updateImgByEmpNo(int empno , byte[] img);
}

package com.jamari.service;

import java.util.List;

import com.jamari.model.Emp;


public interface EmpService {
	
	public List<Emp> getAll();

	public int updateByEmpNo(int empno, String ename);
	
	public int deleteByEmpNo(int empno); 
	
	public int insertByEname(String ename);
	
}

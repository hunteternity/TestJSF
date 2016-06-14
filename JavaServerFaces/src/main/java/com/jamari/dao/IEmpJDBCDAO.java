package com.jamari.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jamari.model.Emp;
import com.jamari.service.EmpService;

public interface IEmpJDBCDAO  {

	 
	 	
	public List<Emp> getAll() ;
	
	public int updateByEmpNo(int empno,String ename) ;

	public int deleteByEmpNo(int empNo) ;

	public int insertByEname(String ename) ;
}

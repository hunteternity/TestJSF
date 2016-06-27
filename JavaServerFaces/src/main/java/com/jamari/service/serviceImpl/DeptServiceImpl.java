package com.jamari.service.serviceImpl;

import java.util.List;

import com.jamari.dao.daoImpl.DeptJDBCDAO;
import com.jamari.model.Dept;
import com.jamari.service.DeptService;

public class DeptServiceImpl implements DeptService {
	private DeptJDBCDAO dao;
//	private DeptJDBCDAOH2 dao;
	
	public DeptServiceImpl(){
		dao = new DeptJDBCDAO();
//		dao = new DeptJDBCDAOH2();
	}
	
	public List<Dept> getAll(){
		return dao.getAll();
	}
	
}

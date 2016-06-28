package com.jamari.dao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jamari.dao.DeptDAO_Interface;
import com.jamari.model.Dept;

public class DeptJDBCDAOH2 implements DeptDAO_Interface{

	String driver = "org.h2.Driver";
//	jdbc:h2:/data/sample;IFEXISTS=TRUE
//	String url = "jdbc:h2:mem:testdb;INIT=runscript from \'classpath:scripts/jamari.sql\';LOCK_MODE=1;MVCC=TRUE;DB_CLOSE_DELAY=-1;MODE=Oracle;TRACE_LEVEL_SYSTEM_OUT=3;TRACE_LEVEL_FIle=4";
	String url = "jdbc:h2:~/sample;IFEXISTS=TRUE";
	String userid = "sa";
	String passwd = "";
	
	private static final String GET_ALL_STMT = "SELECT * from dept order by deptno";
	
	@Override
	public List<Dept> getAll() {
		List<Dept> list = new ArrayList<Dept>();
		Dept Dept = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dept = new Dept();
				Dept.setDeptno(rs.getInt("deptno"));
				Dept.setDname(rs.getString("dname"));
				Dept.setLoc(rs.getString("loc"));
				
				list.add(Dept);
			}
		}catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return list;
		}
}

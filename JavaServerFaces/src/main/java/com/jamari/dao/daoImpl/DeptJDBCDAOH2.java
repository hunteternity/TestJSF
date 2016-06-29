package com.jamari.dao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.jamari.dao.DeptDAO_Interface;
import com.jamari.model.Dept;

public class DeptJDBCDAOH2 implements DeptDAO_Interface {

	String driver = "org.h2.Driver";
	// jdbc:h2:/data/sample;IFEXISTS=TRUE
	String url = "jdbc:h2:mem:testdb";
	// String url = "jdbc:h2:~/sample;IFEXISTS=TRUE";
	String userid = "sa";
	String passwd = "";

	private static final String GET_ALL_STMT = "SELECT * from dept order by deptno";

	private DataSource ds;

	public void initDataSource() {
		BasicDataSource mysqlDS = null;
		if (ds == null) {
			mysqlDS = new BasicDataSource();
			mysqlDS.setDriverClassName(driver);
			mysqlDS.setUrl(url);
			mysqlDS.setUsername(userid);
			mysqlDS.setPassword(passwd);
			ds = mysqlDS;
		}
	}

	@Override
	public List<Dept> getAll() {
		initDataSource();
		
		List<Dept> list = new ArrayList<Dept>();
		Dept Dept = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dept = new Dept();
				Dept.setDeptno(rs.getInt("deptno"));
				Dept.setDname(rs.getString("dname"));
				Dept.setLoc(rs.getString("loc"));

				list.add(Dept);
			}
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
		} 
		catch (SQLException se) {
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

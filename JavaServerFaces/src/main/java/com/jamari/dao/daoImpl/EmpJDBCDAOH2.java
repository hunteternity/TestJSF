package com.jamari.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jamari.dao.EmpDAO_Interface;
import com.jamari.model.Dept;
import com.jamari.model.Emp;

public class EmpJDBCDAOH2 implements EmpDAO_Interface {

	private static DataSource ds = null;
	
	static{
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/testdb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
//		ConnectionPoolDataSource mysqlDS = null;
//		if(ds == null ){
//			mysqlDS = new BasicDataSource();
//			mysqlDS = new  	();
//			mysqlDS.setDriverClassName(driver);
//			mysqlDS.setUrl(url);
//			mysqlDS.setUsername(userid); 
//			mysqlDS.setPassword(passwd);
//			ds = mysqlDS;
//		} 
	}
	
	String driver = "org.h2.Driver";
	private  String url = "jdbc:h2:mem:testdb;INIT=runscript from \'classpath:scripts/jamari.sql\';LOCK_MODE=1;MVCC=TRUE;DB_CLOSE_DELAY=-1;MODE=Oracle";
//	String url = "jdbc:h2:file:/data/sample";
	String userid = "sa";
	String passwd = "";
	
	private static final String GET_ALL_STMT = "SELECT * from emp order by empno";
	private static final String GET_ALL_DEPT_STMT = "SELECT * from dept order by deptno";
	private static final String GET_BY_DEPTNO = "SELECT * from emp where deptno = ? order by empno";
	private static final String GET_BY_EMPNO = "SELECT * from emp where empno = ?";
	private static final String UPDATE = "UPDATE emp set ename=? where empno = ?";
	private static final String UPDATE_IMG_BY_EMPNO = "UPDATE emp set pic = ? where empno = ?";
	private static final String DELETE = "DELETE from emp where empno = ?";
	private static final String INSERT_STMT = "INSERT INTO emp VALUES (emp_seq.NEXTVAL, null,?,null,null,2,2,null,null)";
	
	
	

	@Override
	public List<Emp> getAll() {
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			 
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setComm(rs.getDouble("comm"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setJobno(rs.getInt("jobno"));
				emp.setPic(rs.getBytes("pic"));
				
				list.add(emp);
			}
//		}catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
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
	@Override
	public int updateByEmpNo(int empno,String ename) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, ename);
			pstmt.setInt(2,empno);
			
			updateCount = pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return updateCount;
	}
	@Override
	public int deleteByEmpNo(int empNo) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			
			pstmt.setInt(1, empNo);

			updateCount = pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return updateCount;
	}
	@Override
	public int insertByEname(String ename) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, ename);
			
			updateCount = pstmt.executeUpdate();

			// Handle any driver errors
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
		return updateCount;
	}
	@Override
	public List<Emp> getByDeptNo(int deptno) {
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_DEPTNO);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setComm(rs.getDouble("comm"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setJobno(rs.getInt("jobno"));
				
				list.add(emp);
			}
//		}catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
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
	@Override
	public int updateImgByEmpNo(int empno,byte[] img) {
		int updateCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_IMG_BY_EMPNO);

			pstmt.setBytes(1, img);
			pstmt.setInt(2,empno);
			
			updateCount = pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return updateCount;
	}
		
	@Override
	public Emp getByEmpNo(int empno) {
		Emp emp = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_EMPNO);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setComm(rs.getDouble("comm"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setJobno(rs.getInt("jobno"));
				emp.setPic(rs.getBytes("pic"));
			}
//		}catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
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
			return emp;
		}
	@Override
	public List<Dept> getAllDept() {
		List<Dept> list = new ArrayList<Dept>();
		Dept Dept = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con  =ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_DEPT_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dept = new Dept();
				Dept.setDeptno(rs.getInt("deptno"));
				Dept.setDname(rs.getString("dname"));
				Dept.setLoc(rs.getString("loc"));
				
				list.add(Dept);
			}
//		}catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
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

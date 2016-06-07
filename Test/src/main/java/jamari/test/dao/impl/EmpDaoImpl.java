package jamari.test.dao.impl;

import jamari.base.dao.impl.BaseDao;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;
import jamari.test.dao.EmpDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {

	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> selectByDept(int deptno) {
		Criteria query = getCurrentSession().createCriteria(Emp.class);
		Dept dept = new Dept(deptno,"CHT","FFS");
		query.add(Restrictions.eq("deptno", dept));
		return query.list();
	}
	
	@Override
	public Emp selectByEmpNo(int empno) {
		Criteria query = getCurrentSession().createCriteria(Emp.class);
		query.add(Restrictions.eq("empno", empno));
		return (Emp)query.list().get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> selectByEname(String ename) {
		Criteria query = getCurrentSession().createCriteria(Emp.class);
		query.add(Restrictions.like("ename", "%"+ename+"%"));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> namedQuery() {
		Query query = getCurrentSession().getNamedQuery("getAllEmp");
		List<Emp> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> selectHQL() {
		
//		String sql = "select * from Emp";
//		SQLQuery query = getCurrentSession().createSQLQuery(sql);
		String hql = "select e from Emp as e";
		Query query = getCurrentSession().createQuery(hql);
		
		return query.list();
	}

}

package jamari.test.dao.impl;

import jamari.base.dao.impl.BaseDao;
import jamari.entities.test.Dept;
import jamari.test.dao.DeptDao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao {
	@Override
	public Dept selectByDept(int deptno) {
		Criteria query = getCurrentSession().createCriteria(Dept.class);
		query.add(Restrictions.eq("deptno", deptno));
		return (Dept)query.uniqueResult();
	}
}

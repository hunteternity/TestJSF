package jamari.test.dao.impl;

import jamari.base.dao.impl.BaseDao;
import jamari.entities.test.Jobno;
import jamari.test.dao.JobDao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class JobDaoImpl extends BaseDao<Jobno> implements JobDao {
	@Override
	public Jobno selectByJobno(int jobno) {
		Criteria query = getCurrentSession().createCriteria(Jobno.class);
		query.add(Restrictions.eq("jobno", jobno));
		return (Jobno)query.list().get(0);
	}
}

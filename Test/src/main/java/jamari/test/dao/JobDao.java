package jamari.test.dao;


import jamari.base.dao.IDao;
import jamari.entities.test.Jobno;

public interface JobDao extends IDao<Jobno> {
	Jobno selectByJobno(int jobno);
}

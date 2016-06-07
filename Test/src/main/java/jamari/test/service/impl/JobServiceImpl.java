package jamari.test.service.impl;

import jamari.base.service.impl.BaseService;
import jamari.entities.test.Emp;
import jamari.entities.test.Jobno;
import jamari.test.dao.EmpDao;
import jamari.test.dao.JobDao;
import jamari.test.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends BaseService<Jobno> implements JobService {

	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Override
	public void delete(Jobno bean) {
		Jobno jobno = jobDao.find(Jobno.class, bean.getJobno());
		for (Emp emp : jobno.getEmps()) {
			empDao.delete(emp);
		}
		super.delete(jobno);
	}

	@Override
	public Jobno selectByJobno(int jobno) {
		
		return jobDao.selectByJobno(jobno);
	}
	
	
}

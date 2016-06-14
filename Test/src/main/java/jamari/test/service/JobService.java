package jamari.test.service;

import jamari.base.service.IService;
import jamari.entities.test.Jobno;

public interface JobService extends IService<Jobno> {

	Jobno selectByJobno(int jobno);
}

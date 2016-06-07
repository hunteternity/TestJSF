package jamari.test.service;

import java.util.List;

import jamari.base.service.IService;
import jamari.entities.test.Dept;
import jamari.entities.test.Emp;

public interface DeptService extends IService<Dept> {

	Dept selectByDept(int dept);
}

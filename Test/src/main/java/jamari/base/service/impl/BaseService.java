package jamari.base.service.impl;

import jamari.base.dao.IDao;
import jamari.base.service.IService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseService<T> implements IService<T> {

	@Autowired
	private IDao<T> dao;
	
	public IDao<T> getDao() {
		return dao;
	}
	
	@Override
	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	@Override
	public void create(T bean) {
		dao.create(bean);
	}

	@Override
	public void save(T bean) {
		dao.save(bean);
	}

	@Override
	public void delete(T bean) {
		dao.delete(bean);		
	}

	@Override
	public List<T> list() {
		return dao.list();
	}
	
	@Override
	public List<T> list(String column, Boolean order) {
		return dao.list(column, order);
	}
	
}

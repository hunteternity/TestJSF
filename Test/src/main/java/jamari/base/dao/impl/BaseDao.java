package jamari.base.dao.impl;

import jamari.base.dao.IDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> implements IDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T find(Class<T> clazz, int id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public void create(T bean) {
		getCurrentSession().persist(bean);
	}

	@Override
	public void save(T bean) {
		getCurrentSession().saveOrUpdate(bean);
	}

	@Override
	public void delete(T bean) {
		getCurrentSession().delete(bean);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return getCurrentSession().createCriteria(getGenericClass()).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> list(String column, Boolean order) {
		Criteria query = getCurrentSession().createCriteria(getGenericClass()); 
		if(order){
			query.addOrder(Order.asc(column)).list();
		}else{
			query.addOrder(Order.desc(column)).list();
		}
		return query.list();
		
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}

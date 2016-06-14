package jamari.base.service;

import java.util.List;

public interface IService<T> {

	T find(Class<T> clazz, int id);
	
	void create(T bean);
	
	void save(T bean);
	
	void delete(T bean);
	
	List<T> list();
	
	List<T> list(String column, Boolean order);
	
}

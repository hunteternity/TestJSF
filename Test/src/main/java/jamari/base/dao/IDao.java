package jamari.base.dao;

import java.util.List;

public interface IDao<T> {
	
	/** find by PK */
	T find(Class<T> clazz, int id);
	
	/** insert into */
	void create(T bean);
	
	/** update */
	void save(T bean);
	
	/** delete from */
	void delete(T bean);
	
	/** get all */
	List<T> list();
	
	/** get all order by column asc/desc */
	List<T> list(String column, Boolean order);
	
}

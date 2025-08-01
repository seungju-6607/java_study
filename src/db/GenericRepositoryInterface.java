package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	void remove(String no);
	void update(T entity);
	T find(String no);
	boolean insert(T entity);
	int getCount();
	List<T> findAll();
}

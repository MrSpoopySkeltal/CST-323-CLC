package com.gaminghub.app.data;

import java.util.List;

public interface DataAccessInterface<T> {
	List<T> findAll();
	List<T> findRange(int limit, int offset);
	T findById(int id);
	boolean create(T t);
	boolean update(T t);
	boolean delete(T t);
	boolean delete(int id);
	int getCount();
}
package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;

public interface BookRepository {
	boolean insert(Book book);
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remove(Book book);
	void remove(String id);
	int getCount();
	
	
	
}

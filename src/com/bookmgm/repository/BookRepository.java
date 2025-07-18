package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;

public interface BookRepository {
	boolean insert(Book book);
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remobe(String id);
	int getCount();
}

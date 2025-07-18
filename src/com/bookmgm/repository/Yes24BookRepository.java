package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

public class Yes24BookRepository implements BookRepository{

	List<Book> library = new ArrayList<Book>();
	
	public Yes24BookRepository() {
		System.out.println("** 예스24 도서관 생성 완료 **" );
	}
	
	@Override
	public boolean insert(Book book) {
		if(book != null) {
		return library.add(book);
	} else {
		return false;
		}
    }
	
	
	public List<Book> selectAll(){
		return library;
	}
	public Book select(String id) {
		Book book = null;
		
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
				
		
		return book;
	}
	public void update(Book book) {
		int idx = -1;
		for(int i =0; i<library.size(); i++) {
			Book b = library.get(i);
			if(b.getId().equals(book.getId())) {
				idx = i;
				break;
			}
		}
		library.set(idx, book);
	}
	
	
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) {
				ie.remove();
				break;
			}
		}
	}
	
	public void remove(Book book) {
		
	}
	
	public int getCount() {
		return library.size();
	}
}

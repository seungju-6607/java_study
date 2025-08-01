package com.bookmgm.repository;

import java.util.List;
import com.bookmgm.model.Book;

public interface BookRepository {
    boolean insert(Book book);
    List<Book> listAll();
    Book search(String bid);    
    int update(Book book);
    int delete(String bid);
    int getCount();
}

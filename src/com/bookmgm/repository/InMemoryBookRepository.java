package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.bookmgm.model.Book;

public class InMemoryBookRepository implements BookRepository {

    List<Book> library = new ArrayList<>();

    public InMemoryBookRepository() {
        System.out.println("** 교육센터 도서관 생성 완료 **");
    }

    @Override
    public boolean insert(Book book) {
        if (book != null) {
            return library.add(book);
        }
        return false;
    }

    @Override
    public List<Book> listAll() {
        return library;
    }

    @Override
    public Book search(String bid) {
        for (Book book : library) {
            if (book.getBid().equals(bid)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public int update(Book book) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getBid().equals(book.getBid())) {
                library.set(i, book);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int delete(String bid) {
        Iterator<Book> iterator = library.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBid().equals(bid)) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int getCount() {
        return library.size();
    }
}

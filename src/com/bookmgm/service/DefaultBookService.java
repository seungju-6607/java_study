package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinbBookRepository;
import com.bookmgm.repository.BookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

public class DefaultBookService implements BookService {
    BookManagementApplication bma;
    BookRepository repository;

    public DefaultBookService() {}

    public DefaultBookService(BookManagementApplication bma) {
        this.bma = bma;
        selectRepository();
    }

    public Book createBook() {
        Random rd = new Random();
        Book book = new Book();
        // bid는 고유 식별자이므로 숫자 4자리 형식으로 생성 (필요시 변경)
        book.setBid("B" + String.format("%03d", rd.nextInt(1, 999)));

        System.out.print("도서명> ");
        book.setTitle(bma.scan.next());

        System.out.print("저자> ");
        book.setAuthor(bma.scan.next());

        System.out.print("가격> ");
        book.setPrice(bma.scan.nextInt());

        return book;
    }

    public Book createBook(Book book) {
        System.out.print("도서명> ");
        book.setTitle(bma.scan.next());

        System.out.print("저자> ");
        book.setAuthor(bma.scan.next());

        System.out.print("가격> ");
        book.setPrice(bma.scan.nextInt());

        return book;
    }

    public void selectRepository() {
        System.out.println("--------------------------------------------");
        System.out.println("1. 교육센터 2. 알라딘 3. 예스24");
        System.out.println("--------------------------------------------");
        System.out.print("도서관 선택> ");
        int rno = bma.scan.nextInt();
        if (rno == 1) {
            repository = new InMemoryBookRepository();
        } else if (rno == 2) {
            repository = new AladinbBookRepository();
        } else if (rno == 3) {
            repository = new Yes24BookRepository();
        }
    }

    @Override
    public void register() {
        Book book = createBook();
        if (repository.insert(book)) {
            System.out.println("도서가 등록되었습니다.");
        } else {
            System.out.println("도서 등록 실패.");
        }
        bma.showMenu();
    }

    @Override
    public void list() {
        List<Book> library = repository.listAll();
        if (!library.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("도서번호\t도서명\t저자\t가격");
            System.out.println("------------------------------------------------");
            library.forEach(this::printBook);
        } else {
            System.out.println("등록된 도서가 존재하지 않습니다.");
        }
        bma.showMenu();
    }

    @Override
    public void search() {
        if (getCount() != 0) {
            System.out.print("도서번호> ");
            bma.scan.nextLine(); // 버퍼 비우기
            String bookId = bma.scan.nextLine().trim();
            Book book = repository.search(bookId);
            if (book != null) {
                printBook(book);
            } else {
                System.out.println("검색한 도서가 존재하지 않습니다.");
            }
        } else {
            System.out.println("등록된 도서가 존재하지 않습니다.");
        }
        bma.showMenu();
    }

    @Override
    public void update() {
        System.out.print("도서번호> ");
        bma.scan.nextLine(); // 버퍼 비우기
        String bookId = bma.scan.nextLine().trim();
        Book book = repository.search(bookId);
        if (book != null) {
            Book updatedBook = createBook(book);
            int result = repository.update(updatedBook);
            if (result > 0) {
                System.out.println("도서가 수정되었습니다.");
                printBook(updatedBook);
            } else {
                System.out.println("수정 실패.");
            }
        } else {
            System.out.println("검색한 도서가 존재하지 않습니다.");
        }
        bma.showMenu();
    }

    @Override
    public void remove() {
        System.out.print("도서번호> ");
        bma.scan.nextLine(); // 버퍼 비우기
        String bookId = bma.scan.nextLine().trim();
        int result = repository.delete(bookId);
        if (result > 0) {
            System.out.println("도서가 삭제되었습니다.");
        } else {
            System.out.println("도서가 존재하지 않습니다.");
        }
        bma.showMenu();
    }

    @Override
    public void exit() {
        System.out.println("-- 시스템을 종료합니다 --");
        System.exit(0);
    }

    public void printBook(Book book) {
        System.out.println("------------------------------------------------");
        System.out.printf("[%s]\t%s\t%s\t%d\n",
                book.getBid(), book.getTitle(), book.getAuthor(), book.getPrice());
        System.out.println("------------------------------------------------");
    }

    @Override
    public int getCount() {
        return repository.getCount();
    }
}

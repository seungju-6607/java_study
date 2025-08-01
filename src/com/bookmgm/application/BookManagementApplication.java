package com.bookmgm.application;

import java.util.Scanner;
import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplication {

    public Scanner scan = new Scanner(System.in);
    private BookService service;

    public BookManagementApplication() {
        service = new DefaultBookService(this);
    }

    public void showMenu() {
        System.out.println("---------------------------");
        System.out.println("1.도서 등록");
        System.out.println("2.도서 목록 조회");
        System.out.println("3.도서 검색");
        System.out.println("4.도서 수정");
        System.out.println("5.도서 삭제");
        System.out.println("6.종료");
        System.out.println("---------------------------");
        System.out.print("메뉴(숫자)> ");

        int menu = scan.nextInt();

        switch (menu) {
            case 1 -> service.register();
            case 2 -> service.list();
            case 3 -> service.search();
            case 4 -> service.update();
            case 5 -> service.remove();
            case 6 -> service.exit();
            default -> {
                System.out.println("잘못된 메뉴 선택입니다.");
                showMenu();
            }
        }
    }

    public static void main(String[] args) {
        BookManagementApplication app = new BookManagementApplication();
        app.showMenu();
    }
}

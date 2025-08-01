package com.bookmgm.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bookmgm.model.Book;

public class AladinbBookRepository implements BookRepository {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/hrdb2019";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "your_password_here";

    public AladinbBookRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("** 알라딘 도서관(DB 연결) 생성 완료 **");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(Book book) {
        String sql = "INSERT INTO book_tj (bid, title, author, price, bdate) VALUES (?, ?, ?, ?, NOW())";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getBid());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getPrice());
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> listAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT bid, title, author, price FROM book_tj ORDER BY bid";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getString("bid"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book search(String bid) {
        Book book = null;
        String sql = "SELECT bid, title, author, price FROM book_tj WHERE bid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    book = new Book();
                    book.setBid(rs.getString("bid"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPrice(rs.getInt("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public int update(Book book) {
        String sql = "UPDATE book_tj SET title = ?, author = ?, price = ? WHERE bid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPrice());
            pstmt.setString(4, book.getBid());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String bid) {
        String sql = "DELETE FROM book_tj WHERE bid = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bid);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM book_tj";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

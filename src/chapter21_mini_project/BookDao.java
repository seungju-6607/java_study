package chapter21_mini_project;

import java.util.Scanner;
import db.DBConn;

public class BookDao extends DBConn {
    Scanner scan = new Scanner(System.in);
    MemberVo mvo = new MemberVo();

    public BookDao() {
        super();
    }

    public void insert() {
    	MemberVo mvo = new MemberVo();
        System.out.print("회원 아이디를 입력하세요: ");
        mvo.setMemberId(scan.next());

        System.out.print("사용자명을 입력하세요: ");
        mvo.setUsername(scan.next());

        System.out.print("당신의 이름을 입력하세요: ");
        mvo.setName(scan.next());

        System.out.print("전화번호를 입력하세요: ");
        mvo.setPhone(scan.next());

        menuGuestInfo(mvo); 
        select();
    }

    public void select() {
        System.out.println("****************************************************");
        System.out.println("\tWelcome to Shopping Mall");
        System.out.println("\tWelcome to Book Market!");
        System.out.println("****************************************************");
        System.out.println("1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
        System.out.println("7. 영수증 표시하기\t\t8. 종료");
        System.out.println("****************************************************");
        choice();
    }

    public void choice() {
        System.out.print("메뉴 번호를 선택해주세요 : ");
        int menunumber = scan.nextInt();
        System.out.println(menunumber + "번을 선택했습니다.");

        switch (menunumber) {
            case 1:  
                menuGuestInfoView();
                break;
            case 2:  
                menuCartItemList();
                break;
            case 3:  
                menuCartClear();
                break;
            case 4:  
                menuCartAddItem();
                break;
            case 5:  
                menuCartRemoveItemCount();
                break;
            case 6:  
                menuCartRemoveItem();
                break;
            case 7:  
                menuCartBill();
                break;
            case 8:  
                menuExit();
                break;
            default:
                System.out.println("메뉴 준비 중입니다.");
                break;
        }
        select();
    }


    public void menuGuestInfo(MemberVo mvo) {
        try {
            String sql = """
                    INSERT INTO book_market_member(member_id, username, name, phone)
                    VALUES (?, ?, ?, ?)
                    """;
            getPreparedStatement(sql);
            pstmt.setString(1, mvo.getMemberId());
            pstmt.setString(2, mvo.getUsername());
            pstmt.setString(3, mvo.getName());
            pstmt.setString(4, mvo.getPhone());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("회원 정보가 성공적으로 등록되었습니다!");
            } else {
                System.out.println("회원 정보 등록 실패.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

 

    public void menuGuestInfoView() {
        System.out.println("[고객 정보 확인하기]");
        try {
            String sql = "SELECT member_id, username, name, phone FROM book_market_member";
            getPreparedStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("-----------------------------------------------------");
            System.out.println("ID\t사용자명\t이름\t전화번호");
            System.out.println("-----------------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString("member_id") + "\t");
                System.out.print(rs.getString("username") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.println(rs.getString("phone"));
            }

            System.out.println("-----------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


    public void menuCartItemList() {
        try {
            String sql = """
                SELECT c.cart_id, c.quantity, m.member_id, m.username, b.book_id, b.title, b.author, b.price
                FROM book_market_cart c
                JOIN book_market_member m ON c.member_id = m.member_id
                JOIN book_market_books b ON c.book_id = b.book_id
            """;
            getPreparedStatement(sql);

            rs = pstmt.executeQuery();  // SELECT는 executeQuery()

            System.out.println("장바구니 목록:");
            while (rs.next()) {
                System.out.printf("Cart ID: %d | Member: %s | Book: %s | Author: %s | Price: %.2f | Quantity: %d\n",
                    rs.getInt("cart_id"),
                    rs.getString("username"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void menuCartClear() {
        System.out.println("[장바구니 비우기]");
        try {
            String sql = "DELETE FROM  book_market_cart";
            getPreparedStatement(sql);
            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "장바구니를 비웠습니다!" : "비울 항목이 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        select();
    }


    public void menuCartAddItem() {
        try {
            System.out.print("회원 ID 입력: ");
            int memberId = scan.nextInt();

            System.out.print("책 ID 입력: ");
            int bookId = scan.nextInt();

            System.out.print("수량 입력: ");
            int quantity = scan.nextInt();

            String sql = "INSERT INTO book_market_cart(member_id, book_id, quantity) VALUES (?, ?, ?)";
            getPreparedStatement(sql);

            pstmt.setInt(1, memberId);
            pstmt.setInt(2, bookId);
            pstmt.setInt(3, quantity);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("장바구니에 항목이 추가되었습니다.");
            } else {
                System.out.println("장바구니 항목 추가 실패.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void menuCartRemoveItemCount() {
        System.out.println("[장바구니의 항목 수량 줄이기]");
        System.out.print("도서 ID: ");
        String itemId = scan.next();
        System.out.print("줄일 수량: ");
        int decrease = scan.nextInt();

        try {
            String sql = "UPDATE book_market_cart SET quantity = quantity - ? WHERE book_id = ?";
            getPreparedStatement(sql);
            pstmt.setInt(1, decrease);
            pstmt.setString(2, itemId);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "수량이 줄어들었습니다!" : "해당 도서를 찾을 수 없거나 이미 수량이 0입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        select();
    }

    public void menuCartRemoveItem() {
        System.out.println("[장바구니의 항목 삭제하기]");
        System.out.print("삭제할 도서 ID: ");
        String itemId = scan.next();

        try {
            String sql = "DELETE FROM book_market_cart WHERE book_id = ?";
            getPreparedStatement(sql);
            pstmt.setString(1, itemId);

            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "항목이 삭제되었습니다!" : "해당 도서를 찾을 수 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        select();
    }


    public void menuCartBill() {
        try {
            String sql = """
                SELECT c.cart_id, c.quantity, b.title, b.author, b.price
                FROM book_market_cart c
                JOIN book_market_books b ON c.book_id = b.book_id
            """;
            getPreparedStatement(sql);

            rs = pstmt.executeQuery();

            double total = 0;
            System.out.println("영수증:");
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double itemTotal = price * quantity;
                total += itemTotal;

                System.out.printf("책: %s | 저자: %s | 가격: %.2f | 수량: %d | 합계: %.2f\n",
                        title, author, price, quantity, itemTotal);
            }
            System.out.printf("총 결제 금액: %.2f\n", total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void menuExit() {
        System.out.println("-- 프로그램 종료 --");
        System.exit(0);
    }
}

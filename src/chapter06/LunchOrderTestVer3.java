package chapter06;

import java.util.Scanner;

public class LunchOrderTestVer3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean searchFlag = true; 
        int totalPrice = 0;       
        int orderCount = 0;      
        String[] ordermenuList = new String[5]; 
        int[] orderPriceList = new int[5];     

        while (searchFlag) {
        	
            System.out.println("*************************************");
            System.out.println("\t 1. 햄버거(🍔) : 100  \t 2. 피자(🍕) : 200");
            System.out.println("\t 3. 라면(🍜) : 300 \t 4. 샐러드(🥗) : 400");
            System.out.println("*************************************");
            System.out.print("주문 메뉴(숫자로) > ");

         
            if (!scan.hasNextInt()) {
                System.out.println("=> 숫자를 다시 입력해주세요.");
                scan.next(); 
              
            }

            int menuNo = scan.nextInt();
            String menuName = "";
            int menuPrice = 0;      
            switch (menuNo) {
                case 1:
                    menuName = "햄버거(🍔)";
                    menuPrice = 100;
                    break;
                case 2:
                    menuName = "피자(🍕)";
                    menuPrice = 200;
                    break;
                case 3:
                    menuName = "라면(🍜)";
                    menuPrice = 300;
                    break;
                case 4:
                    menuName = "샐러드(🥗)";
                    menuPrice = 400;
                    break;
                default:
                    System.out.println("해당 메뉴는 없습니다. 다시 선택해주세요.");
            }
            ordermenuList[orderCount] = menuName;
            orderPriceList[orderCount] = menuPrice;
            orderCount++;
            totalPrice += menuPrice;

            System.out.println("=> 주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원입니다.");
            System.out.print("계속 주문하시겠습니까? (계속: 아무 키, 종료: n) > ");
            scan.next();
            if (scan.next().equals("n")) {
                searchFlag = false;
            }
        }
        System.out.println("총 주문 금액: " + totalPrice + "원");
        System.out.println("주문 내역:");
        for (int i = 0; i < orderCount; i++) {
            System.out.println("- " + ordermenuList[i] + ": " + orderPriceList[i] + "원");
        }

    }
}

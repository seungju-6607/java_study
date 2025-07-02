package chapter06;

import java.util.Scanner;

public class LunchOrderTestVer3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean searchFlag = true; 
        int totalPrice = 0;       
        int orderCount = 0;   
        String menuName = "";
        int menuPrice = 0;
        int quantity = 0;
        int totalCost = 0;
        int charge =0;
        
        String[] ordermenuList = new String[5]; 
        int[] orderPriceList = new int[5];
        int[] quantityList = new int[5]; 
         
        while (searchFlag) {
            System.out.println("*************************************");
            System.out.println("\t 1. 햄버거(🍔) : 100  \t 2. 피자(🍕) : 200");
            System.out.println("\t 3. 라면(🍜) : 300 \t 4. 샐러드(🥗) : 400");
            System.out.println("\t 9. 나가기");
            System.out.println("*************************************");
            System.out.print("주문 메뉴(숫자로) > ");

            if (!scan.hasNextInt()) {
                System.out.println("=> 숫자를 다시 입력해주세요.");
                scan.next(); 
            }

            int menuNo = scan.nextInt();     
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
                case 9:
                    searchFlag = false;
                    break;
                default:
                    System.out.println("메뉴준비중입니다. 다시 선택해주세요.");
            }


            System.out.print("갯수 선택 > ");
            while (true) {
                if (!scan.hasNextInt()) {
                    System.out.print("올바르지 않은 입력값입니다. 다시 입력해주세요. > ");
                    scan.next();
                } else {
                    quantity = scan.nextInt();
                    break;
                }
            }

            totalCost = menuPrice * quantity;
            ordermenuList[orderCount] = menuName;
            orderPriceList[orderCount] = menuPrice;
            quantityList[orderCount] = quantity;
            orderCount++;
            totalPrice += totalCost;

            System.out.println("=> 주문하신 메뉴는 " + menuName + ", " + quantity + "개, 가격은 " + totalCost + "원입니다.");
            System.out.print("계속 주문하시겠습니까? (계속: 아무 키, 종료: n) > ");
            if (scan.next().equals("n")) {
                searchFlag = false;
            }
        }

        System.out.println("\n주문 내역:");
        for (int i = 0; i < orderCount; i++) {
            int itemTotal = orderPriceList[i] * quantityList[i];
            System.out.println("- " + ordermenuList[i] + " " + quantityList[i] + "개: " + itemTotal + "원");
        }

        System.out.println("총 주문 금액: " + totalPrice + "원");

        System.out.print("결제할 요금 입력 > ");
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.print("올바르지 않은 입력값입니다. 다시 입력해주세요. > ");
                scan.next();
            } else {
                charge = scan.nextInt();
                break;
            }
        }

        if (charge > totalPrice) {
            System.out.println("잔돈은 " + (charge - totalPrice) + "원입니다.");
        } else if (charge == totalPrice) {
            System.out.println("정확한 금액을 지불하셨습니다.");
        } else {
            System.out.println("금액이 부족합니다. 주문을 다시 시도해주세요.");
        }

    }
}

package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 스캐너 생성

        while (true) {
            // 메뉴판 출력
            System.out.println("*************************************");
            System.out.println("\t Welcome to Food Mart!!!");
            System.out.println("*************************************");
            System.out.println("\t 1. 햄버거(🍔) : 100  \t 2. 피자(🍕) : 200");
            System.out.println("\t 3. 라면(🍜) : 300 \t 4. 샐러드(🥗) : 400");
            System.out.println("\t 9. 나가기");
            System.out.println("*************************************");

            System.out.print("메뉴 번호 선택 > ");
            while(true) {
                if (!scan.hasNextInt()) {
                System.out.print("올바르지 않은 입력값입니다. 다시 입력해주세요. > ");
                scan.next();
               }else {
            	   break;
            	}
            } 

            int menuNo = scan.nextInt();
            String menuName = "";
            int menuPrice = 0;

            // 메뉴 번호에 따라 처리
            switch (menuNo) {
                case 1 : 
                    menuName = "햄버거(🍔)";
                    menuPrice = 100;
                    break;
                
                case 2 : 
                    menuName = "피자(🍕)";
                    menuPrice = 200;
                    break;
                
                case 3 : 
                    menuName = "라면(🍜)";
                    menuPrice = 300;
                    break;
                
                case 4 : 
                    menuName = "샐러드(🥗)";
                    menuPrice = 400;
                    break;
                
                case 9 : 
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                    break;
                
                default :      
                    System.out.println("해당 메뉴는 준비 중입니다. 다시 선택해주세요.");
                    continue;
               
            }

            if (menuNo <= 4) { // 메뉴 선택시 등장
            System.out.println("선택한 음식은: " + menuName + " (하나의 가격: " + menuPrice + "원)");
            }
            
            System.out.print("갯수 선택 > ");
            while(true) {
                if (!scan.hasNextInt()) {
                System.out.print("올바르지 않은 입력값입니다. 다시 입력해주세요. > ");
                scan.next();
               }else {break;}
            } 
            int quantity = scan.nextInt();
            int totalCost = menuPrice * quantity;

            // 총 금액 출력
            System.out.println(menuName + " " + quantity + "개를 선택하셨습니다. 총 금액: " + totalCost + "원");

            // 지불 금액 입력
           
	            System.out.print("결제할 요금 입력 > ");
	            while(true) {
	                if (!scan.hasNextInt()) {
	                System.out.print("올바르지 않은 입력값입니다. 다시 입력해주세요. > ");
	                scan.next();
	               }else {break;}
	            } 
	            int charge = scan.nextInt();
	
	            // 잔돈 또는 부족 여부 계산
	            if (charge > totalCost) {
	                System.out.println("잔돈은 " + (charge - totalCost) + "원입니다.");
	            } else if (charge == totalCost) {
	                System.out.println("정확한 금액을 지불하셨습니다.");
	            } else {
	                System.out.println("금액이 부족합니다. 주문을 다시 시도해주세요.");
	                
	            }
              
            } 
        }
    }


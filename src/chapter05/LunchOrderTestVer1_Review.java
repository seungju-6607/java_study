package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {

	public static void main(String[] args) {
		//메뉴판
		System.out.println("*************************************");
		System.out.println("\t Welcome to Food Mart!!!");
		System.out.println("*************************************");
		System.out.println("\t 1. 햄버거(🍔) : 100  \t 2. 피자(🍕) : 200");
		System.out.println("\t 3. 라면(🍜) : 300 \t 4. 샐러드(🥗) : 400");
		System.out.println("\t 9. 나가기");
		System.out.println("*************************************");
		System.out.println("***** Food Mart에 오신것을 환영합니다 *****");
		
		int menuNo = 1;
		String menuName = "";
		int menuPrice = 0;
		int charge = 0;
		int change = 0;
		int menuget = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴 번호 선택 >");
		if(scan.hasNextInt()) {
		menuNo = scan.nextInt();
		
		switch(menuNo) { 
		case 1 : menuName = "햄버거(🍔)" ; menuPrice = 100 ;  break;
		case 2 : menuName = "피자(🍕)";  menuPrice = 200  ; break;
		case 3 : menuName = "라면(🍜)"; menuPrice = 300 ; break;
		case 4 : menuName = "샐러드(🥗)"; menuPrice = 400 ; break;
		case 9 : System.out.println("나가기"); System.exit(0);
		
		default : System.out.println("메뉴를 준비중입니다.");
		}
	}
		System.out.println("선택한 음식은 : " + menuName + "한개당 가격은 "+  menuPrice + "원입니다.");
		System.out.print("갯수 선택 > ");
		menuget = scan.nextInt();
		System.out.print("선택하신 메뉴 " +  menuName  + "갯수는 " + menuget + "개 ");
		menuget = menuPrice * menuget;
		System.out.println(menuget + "원입니다.");
		System.out.print("내실 금액 선택 > ");
		charge = scan.nextInt();
		if(charge > menuget) {
		change = charge - menuget; 
		System.out.println("잔돈 : " + change + "입니다"  );
		} else {
			System.out.println("돈이모자랍니다.");
		}
		
  } 
}

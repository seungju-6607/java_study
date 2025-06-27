package chapter05;

import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		int menuNo = 0;
		String menuName = "";
		int menuPrice = 0;
		int cost = 0;
		int order = 0;
		System.out.println("[시작]");
		System.out.println("------------------------");
		System.out.println("☕🍵🥤 Mega Coffee Menu");
		System.out.println("------------------------");
		System.out.println("1.☕에마리카노 - 2,800원 ");
		System.out.println("2.🍵바닐라 라떼 - 3,500원");
		System.out.println("3.🥤 딸기 쉐이크 - 4,000원 ");
		System.out.println("------------------------");
	while (true){
		
	
	
		//step 2: 메뉴 주문 기능
		Scanner scan = new Scanner(System.in);
		System.out.print("주문할 메뉴 번호 입력 > ");
		while(true) {
			if (!scan.hasNextInt()){
				System.out.print("올바르지 않은 값입니다. 다시 입력해주세요 >");
				scan.next();
		} else {
			break;
		}
	}
				menuNo = scan.nextInt();	
			
				switch(menuNo) {
				case 1:
					menuName = "☕아메리카노";
					menuPrice = 2800;
					break;
				case 2:
					menuName = "🍵바닐라 라떼";
					menuPrice = 3500;
					break;
				case 3:
					menuName = "🥤딸기 쉐이크";
					menuPrice = 4000;
					break;			
				default :
					System.out.println("준비중입니다");					
				} 
		
		 if(menuNo <= 4 ) {
				System.out.printf("=> 주문메뉴 : " + menuName + ", 결제 예정 금액 :%,d" , menuPrice);
		 }
     	 
		 System.out.printf("\n가격은 %,d원입니다.\n", menuPrice );
		 
		 System.out.print("총 입금 금액 > " );
		 while(true) {
				if (!scan.hasNextInt()){
					System.out.print("올바르지 않은 값입니다. 다시 입력해주세요 >");
					scan.next();
			} else {
				break;
			}
		}
		 cost = scan.nextInt();
		 
		 
		 int costtotal = cost - menuPrice;
		 if(cost > menuPrice) {
			 System.out.printf("결제완료! 잔돈:%d원" , costtotal);
		 } else if(cost == menuPrice ) {
			 System.out.println("결제완료!");
		 } else {
			 System.out.println("금액이 부족합니다.다시 입력해주세요.");
		 }
		
		 System.out.println();
		 System.out.println();
		 
		 System.out.print("추가 주문(0)을 누르세요 종료(1) > ");
		    order = scan.nextInt();
		    if (order == 1) {
		        System.out.println("[종료]");
		        System.out.println("이용해주셔서 감사합니다.");
		        break; 
		    }
	  }	
	}
}



package chapter03;

import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {
		System.out.println("*************************************");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Food Market");
		System.out.println("*************************************");
		System.out.println("\t1.상풍보기 \t2.상품구입\n\t3.영수증보기\t4.종료");
		System.out.println("*************************************");
		Scanner scan = new Scanner(System.in);
		//선택 메뉴 체크 확인
		while (true) {
		System.out.print("메뉴를 선택해주세요(숫자) > ");
		int number = scan.nextInt();	
		String check = "";
	
		switch(number) {
		case 1 : check = "상품보기";
	    break;
		case 2 : check = "상품구입";
		break;
		case 3 : check = "영수증보기";
		break;
		case 4 : check = "종료";
		break;
		default : 
		System.out.println("다시입력해주세요");
		continue;
		
		}	
		
		System.out.println(check);
		if(number <=4) {
			break;
		}
	}
  }
}

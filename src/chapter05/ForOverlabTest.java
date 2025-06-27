package chapter05;

import java.util.Scanner;

public class ForOverlabTest {

	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		int start,end = 0;
		
		while(true) {
		System.out.print("start(종료:0) > ");
		start = scan.nextInt();
			if(start != 0 ) {
				System.out.print("end(종료:0) > ");
				end = scan.nextInt();
				if(end == 0) {
					System.out.println("- 프로그램 종료 - ");
					System.exit(0);
				}
			    for(int i = 1; i<=9; i++) { // 원하는 숫자만큼 곱하기
				for(int j = start; j<=end; j++) { //원하는 단
					System.out.print(j + "*" + i + "=" + (j*i) + "\t");
				}
				System.out.println();
			} // for 
		    } //if
			else {
		  		System.out.println("- 프로그램 종료 - ");
				System.exit(0);
		    } //else
	     } //while
		
	}

}
  
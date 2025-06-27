package chapter05;

import java.util.Scanner;

/*
 * 반복문 : while(조건식) {실행문(조건식이 true인 경우에만 실행); }
 *        종료되는 시점을 정확하게 알고 있는 경우 사용됨
 */
public class WhileTest {

	public static void main(String[] args) {
		//1~10까지 정수의 합계를 출력
		//시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		int start = 0 , end = 0;
		int sum = 0;
		int i = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("시작 값 >");
		i = start = scan.nextInt();
		
		System.out.print("종료 값 >");
		end = scan.nextInt();
		
		while(i <= end) {
			sum += i;
			i++;
		}
		System.out.println("sum = " + sum);
	}

}

package chapter05;

import java.util.Scanner;

/*
 * 중첩 if
 */

public class IfOverlabTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("수학 > ");
		int math = input.nextInt();
		System.out.print("영어 > ");
		int eng = input.nextInt();
		
		//1. 중첩 if 
		if(math >= 60) {
    	  if(eng >= 60) {
    		  System.out.println("통과");
    	   } 
		}else {
			
			System.out.println("불합격");
		}
		
		//2.논리연산자 &&를 이용하여 if ~ else
		if(math >= 60 && eng >= 60) { 
	    		  System.out.println("통과");	    	   
			} else {				
				System.out.println("불합격");
			}
	}

}

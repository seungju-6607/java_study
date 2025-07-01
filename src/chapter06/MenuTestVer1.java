package chapter06;

import java.util.Scanner;
/*
 * 더조은 레스토랑 메뉴 등록/출력/검색 프로그램
 * - 메뉴는 피자, 햄버거, 라멘, 샐러드
 * - 메뉴명, 이모지, 가격을 저장
 * - 메뉴명, 이모지, 가격은 각각 1차언 배열로 생성하여 관리
 * - 메뉴 관리를 위해서 각 배열의 주소를 통일시킨다.
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 */
public class MenuTestVer1 {

	public static void main(String[] args) {
		//변수 or 객체 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴 갯수> ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] priceList = new int[MAX_SIZE];

		boolean menuFlag = true;
		int menu = 0;
		int count = 0; 
		while(menuFlag) {
			System.out.println("---------------------------------------------");
			System.out.println("\t더조은 레스토랑 메뉴 관리 프로그램");
			System.out.println("---------------------------------------------");
			System.out.println("1. 메뉴 등록");
			System.out.println("2. 메뉴 리스트 출력");
			System.out.println("3. 메뉴 검색");
			System.out.println("9. 프로그램 종료");		
     		System.out.println("---------------------------------------------");
			System.out.print("메뉴선택(숫자) > ");
			menu = scan.nextInt();
			
			if(menu == 1) {
				System.out.println("메뉴 등록");
				for(int i= count;  i < nameList.length; i++) {
		        	System.out.print("메뉴명 등록 > ");
		        	nameList[i] = scan.next();
		        	System.out.print("가격 등록 > ");
		        	priceList[i] = scan.nextInt();     	
		        	count++;	
		        	
		        	System.out.print("계속 입력 하시겠습니까?(계속:아무키나누르세요, 종료:n))");	        	
		        	if(scan.next().equals("n")) {
		        		i = nameList.length;//break;
		        		System.out.printf("=> %d개 음식 등록 완료!!\n",count);
		        	}
		          }				
			}else if(menu == 2) {
				System.out.println("메뉴 리스트 출력");
				if(count != 0) {
					 System.out.println("---------------------------------------------");
					 System.out.println("메뉴\t가격");
				        for(int i = 0; i < nameList.length; i++) {
				        	if(nameList[i] != null) {
					        	System.out.print(nameList[i]+"\t");
					        	System.out.print(priceList[i] +"\n");
				        	}			        				        	
				        }	
				        	System.out.println();
				        	System.out.print("메뉴로 이동하시겠습니까?(계속:아무키나누르세요, 종료:n)");
				        	if(scan.next().equals("n")) {
				        		break;
				            }										        			         
				} 
		 }else if(menu == 3) {
					System.out.println("메뉴 검색");	
			if(count !=0 ) {			  
				  boolean searchFlag = true;
					  while(searchFlag) {
						        System.out.print("메뉴  검색 > ");
						        String searchName = scan.next();
						        int searchIdx = -1;
						        int countIdx =0;
						        for(String name : nameList) {
						        	if(name != null) {
						        	if(name.equals(searchName)) searchIdx = countIdx;
						        	countIdx++;
						        	}
						        }
					if(searchIdx != -1) {
							System.out.println("검색결과 주소 : " + searchIdx);							        
							System.out.println("---------------------------------------------");
							System.out.println("메뉴\t가격");
						    System.out.print(nameList[searchIdx]+"\t");	
						    System.out.print(priceList[searchIdx]+"\n");							    
						    System.out.println("---------------------------------------------");					    	
						    System.out.print("계속 검색 하시겠습니까?(계속:아무키나누르세요, 종료:n))");            					        
						    if(scan.next().equals("n")) {
					     		searchFlag = false;
							   	System.out.println("-- 검색 종료 --");
				           }
					 } 		else {
					        	System.out.println("=> 검색한 데이터가 없음!!");					        	
					 		}
					   }
			  }
		   }
				           else if(menu == 9) {
								System.out.println("-- 프로그램 종료 --");
								System.exit(0);
							}else {
						System.out.println("=> 메뉴 준비중");
					}			 
		}//while

	}//main

}//Class

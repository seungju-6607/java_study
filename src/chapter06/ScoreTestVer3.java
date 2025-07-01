package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer2의 결과에 메뉴를 추가함
 */
public class ScoreTestVer3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		int count = 0; //등록된 학생수 저장
		
		System.out.print("크기입력 > ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		while(menuFlag) {
			System.out.println("---------------------------------------------");
			System.out.println("\t더조은 고등학교 성적관리 프로그램");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("9. 프로그램 종료");		
			System.out.println("---------------------------------------------");

			System.out.print("메뉴선택(숫자) > ");
			menu = scan.nextInt();
			
			if(menu == 1) { //학생 등록
				 for(int i= count;  i < nameList.length; i++) {
			        	System.out.print("학생명 > ");
			        	nameList[i] = scan.next();
			        	System.out.print("국어 > ");
			        	korList[i] = scan.nextInt();
			        	System.out.print("영어 > ");
			        	engList[i] = scan.nextInt();
			        	System.out.print("수학 > ");
			        	mathList[i] = scan.nextInt();
			        	
			        	totList[i] = korList[i]+engList[i]+mathList[i];
			        	avgList[i] = totList[i]/3;
			        	count++;
			        	
			        	System.out.print("계속 입력 하시겠습니까?(계속:아무키나누르세요, 종료:n))");
			        	
			        	if(scan.next().equals("n")) {
			        		i = nameList.length;//break;
			        		System.out.printf("=> %d명 등록 완료!!\n",count);
			        	}
			          }
			} else if(menu == 2) { //학생 리스트 출력
				if(count != 0) {
					 System.out.println("---------------------------------------------");
					 System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
					 System.out.println("---------------------------------------------");
			        for(int i = 0; i < nameList.length; i++) {
			        	//이름이 null이 아닌 경우에만 출력
			        	if(nameList[i] != null) {
				        	System.out.print(nameList[i]+"\t");
				        	System.out.print(korList[i]+"\t");
				         	System.out.print(engList[i]+"\t");
				        	System.out.print(mathList[i]+"\t");
				        	System.out.print(totList[i]+"\t");
				        	System.out.print(avgList[i]+"\n");
			        	}			        	
			        }
			        System.out.println("---------------------------------------------");
				} else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 진행해 주세요");
				}
			} else if(menu == 3) { //학생 성적 검색		
			  if(count !=0 ) {			  
				  boolean searchFlag = true;
			        while(searchFlag) {
				        System.out.print("학생명 검색 > ");
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
					        //Step5 : 데이터 조회 결과 출력
					        //조회할 학생명 입력--> 학생의 naemList 주소를 변수에 저장한다.
					        System.out.println("---------------------------------------------");
					        System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
					        System.out.print(nameList[searchIdx]+"\t");
					    	System.out.print(korList[searchIdx]+"\t");
					     	System.out.print(engList[searchIdx]+"\t");
					    	System.out.print(mathList[searchIdx]+"\t");
					    	System.out.print(totList[searchIdx]+"\t");
					    	System.out.print(avgList[searchIdx]+"\n");
					    	
					    	System.out.println("---------------------------------------------");
					    	
				            System.out.print("계속 검색 하시겠습니까?(계속:아무키나누르세요, 종료:n))");            
				        	if(scan.next().equals("n")) {
				        		searchFlag = false;
				        		System.out.println("-- 검색 종료 --");
			                }
				        } else {
				        	System.out.println("=> 검색한 데이터가 없음!!");
				        }
			        } //while
			  } else {
				  System.out.println("등록된 데이터가 없습니다.");
			  }
			} else if(menu == 9) { //프로그램 종료
				System.out.println("--프로그램 종료--");
				System.exit(0);
			} else {
				System.out.println("메뉴 준비중입니다~");
			}
			
			
			
            System.out.print("계속 진행 하시겠습니까?(계속:아무키나누르세요, 종료:n))");
        	
        	if(scan.next().equals("n")) {
        		menuFlag = false;
        	}
		}//while
		System.out.println("-- 프로그램 종료 --");
	}//main
	
}//class

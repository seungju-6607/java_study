package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer3의 점수 저장을 2차원 배열 구조로 수정함
 */
public class ScoreTestVer4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		int count = 0; //등록된 학생수 저장
		
		System.out.print("크기입력 > ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[][] scoreList = new int[MAX_SIZE][];
		
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
					 String[] subjectList = {"국어","영어","수학"};
			        	System.out.print("학생명 > ");
			        	nameList[i] = scan.next();
			        	
			        	
			        	//학생의 점수를 입력할 배열을 생성함
			        	scoreList[i]= new int[5];
			        	int tot = 0;
			        	int avg = 0;
			        	for(int j = 0; j < subjectList.length; j++) {
			        		System.out.print(subjectList[j] + ">");
			        		scoreList[i][j] = scan.nextInt();	
			        		tot += scoreList[i][j];
			        		avg = tot/subjectList.length;
			        	}
			        	
			        	scoreList[i][scoreList[i].length-2] = tot; //총점
			        	scoreList[i][scoreList[i].length-1] = avg; //평균
			        	
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
			        for(int i = 0; i < count; i++) {   
			        	System.out.print(nameList[i]+"\t");
			        	for(int j=0; j<scoreList[i].length; j++) {
			        		System.out.print(scoreList[i][j]+"\t");
			        	}
			        	System.out.println();      	
			        }			        	
			        System.out.println("---------------------------------------------");
			      }
				 else {
					System.out.println("=> 등록된 데이터가 없습니다. 등록을 진행해 주세요");
				}
			} else if(menu == 3) { //학생 성적 검색		
			    if(count != 0) {			  
			        boolean searchFlag = true;
			        while(searchFlag) {
			            System.out.print("학생명 검색 > ");
			            String searchName = scan.next();
			            int searchIdx = -1;

			            for(int i = 0; i < count; i++) {
			                if(nameList[i].equals(searchName)) {
			                    searchIdx = i;
			                    break;
			                }
			            }

			            if(searchIdx != -1) {
			                // STEP5 : 검색된 학생의 성적 출력
			                System.out.println("검색결과 주소 : " + searchIdx);
			                System.out.println("---------------------------------------------");
			                System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
			                System.out.print(nameList[searchIdx] + "\t");

			                // 점수 출력 (2차원 배열 사용)
			                for (int j = 0; j < scoreList[searchIdx].length; j++) {
			                    System.out.print(scoreList[searchIdx][j] + "\t");
			                }
			                System.out.println("\n---------------------------------------------");

			                System.out.print("계속 검색 하시겠습니까?(계속:아무키나 누르세요, 종료:n) > ");            
			                if(scan.next().equals("n")) {
			                    searchFlag = false;
			                    System.out.println("-- 검색 종료 --");
			                }
			            } else {
			                System.out.println("=> 검색한 데이터가 없음!!");
			            }
			        }
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

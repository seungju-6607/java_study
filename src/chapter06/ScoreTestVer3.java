package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 저수를 입력
 * - 입력받은 과목의 총점과 평균을 구한다.
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입출력을 위해서 각 배열의 주소를 통일시킨다 
 * - 학생 성적 수정 메뉴를 추가한다. (검색 + 등록)
 * - 학생명 및 점수 삭제 메뉴를 추가한다. (검색 + )
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
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
			System.out.println("4. 학생 성적 수정");
			System.out.println("5. 학생 데이터 삭제");
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
			        for(int i = 0; i < count; i++) {
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
			} 
			else if(menu == 3) { //학생 성적 검색		
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
			} else if(menu == 4) { //학생 성적 수정
				//1. 수정할 학생명이 존재여부 검색 : 유 -> 새로운 성적 입력 후 수정
				//1. 수정할 학생명이 존재여부 검색 : 무 -> 검색 데이터 존재X
				if(count != 0) {
	      		boolean modiFlag = true;
				while(modiFlag) {
					System.out.print("[수정]학생명 검색 > ");
					String modifiedName = scan.next();
					int modiIdx = -1;
					for(int i = 0; i<count; i++) {
						if(nameList[i].equals(modifiedName)) modiIdx = i;
					}
					
					if(modiIdx == -1) {
						System.out.println("수정할 데이터가 존재X, 다시 입력해주세요");					
					}else {
						System.out.print("국어 > ");
			        	korList[modiIdx] = scan.nextInt();
			        	System.out.print("영어 > ");
			        	engList[modiIdx] = scan.nextInt();
			        	System.out.print("수학 > ");
			        	mathList[modiIdx] = scan.nextInt();
			        	
			        	totList[modiIdx] = korList[modiIdx]+engList[modiIdx]+mathList[modiIdx];  //총점
			        	avgList[modiIdx] = totList[modiIdx]/3;  //평균
			        	
			        	System.out.println("=> 수정 완료!!");
			        	System.out.print(nameList[modiIdx]+"\t");
				    	System.out.print(korList[modiIdx]+"\t");
				     	System.out.print(engList[modiIdx]+"\t");
				    	System.out.print(mathList[modiIdx]+"\t");
				    	System.out.print(totList[modiIdx]+"\t");
				    	System.out.print(avgList[modiIdx]+"\n");
			        	System.out.print("계속 수정 하시겠습니까?(계속:아무키나누르세요, 종료:n))");
			        	
			        	if(scan.next().equals("n")) {
			        		modiFlag = false;
			        	}
			       }
				}//while - modiFlag
				} else {
					System.out.println("등록된 데이터가 없습니다. 등록을 진행해 주세요");	
				}
			} else if (menu == 5) { //학생 삭제
				if(count != 0) {
					boolean deleteFlag = true;
					while(deleteFlag) {
						System.out.println("[삭제] 학생명 검색 > ");
						String deleteName = scan.next();
						int deleteIdx = -1;
						for(int i = 0; i <count; i++) {
							if(nameList[i].equals(deleteName)) deleteIdx = i;
						}
						
						if(deleteIdx != -1) {
						for(int i =deleteIdx; i < count-1; i++) {	//홍길동(0) 이순신(1) 김유신(2)
							  nameList[i] = nameList[i+1];                                  //이순신(0) 김유신(1)
							  korList[i] = korList[i+1];                                  //이순신(0) 김유신(1)
							  engList[i] =  engList[i+1];                                  //이순신(0) 김유신(1)
							  mathList[i] =  mathList[i+1];                                  //이순신(0) 김유신(1)
							  totList[i] = totList[i+1];                                  //이순신(0) 김유신(1)
							  avgList[i] =avgList[i+1];  
							  //이순신(0) 김유신(1)
			       			}
				          		count --;
						      System.out.print("계속 삭제 하시겠습니까?(계속:아무키나누르세요, 종료:n))");
					        	
					        	if(scan.next().equals("n")) {
					        		deleteFlag = false;
					        	}
						} else {
						    System.out.println("삭제할 데이터가 존재X, 다시 입력해주세요");	
						}
						
					}// while-deleteFlag
				}
			}else if(menu == 9) { //프로그램 종료
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

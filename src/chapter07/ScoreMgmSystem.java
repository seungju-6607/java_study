package chapter07;

import java.util.Scanner;

public class ScoreMgmSystem {
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] sList = new Student[10];
	int count = 0;
	
	public ScoreMgmSystem() {
		
	}
	
	//Method
	/*
	 * 메뉴 선택 
	 */
	
	public void showMenu() {
	
		System.out.println("---------------------------------------------");
		System.out.println("\t더조은 고등학교 성적관리 프로그램");
		System.out.println("---------------------------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 데이터 삭제");
		System.out.println("9. 프로그램 종료");		
		System.out.println("---------------------------------------------");
		
		System.out.print("메뉴선택(숫자) > ");
//		int menu = scan.nextInt();
//		choiceMenu(menu);
		
		menuCheck(scan.nextInt());
	}
	
	/*
	 * 선택한 메뉴에 따라 기능별 메소드 호출
	 */
	public void menuCheck(int menu) {
		System.out.println("menuCheck ---> " + menu);
		switch (menu) {
		case 1: 
			insert();
			showMenu();
			break;
		case 2: 
			showList();
			showMenu();
			break;
		case 3:
			search();
			showMenu();
			break;
		case 4:
			update();
			showMenu();
			break;
		case 5:
			remove();
			showMenu();
			break;
		case 9:
			System.out.println("--성적 관리 시스템 종료--");
            System.exit(0);
            break;
        default:
            System.out.println("메뉴 준비 중~");
            showMenu();
		}
	}
	
	public void insert() {
		System.out.println("=> 학생 정보 등록하세요");	
		sList[count] = new Student();
		System.out.print("학생명 > ");
		sList[count].name = scan.next();
		
		System.out.print("국어점수 > ");
		sList[count].kor = scan.nextInt();
		
		System.out.print("영어점수 > ");
		sList[count].eng = scan.nextInt();
		
		System.out.print("수학점수 > ");
		sList[count].math = scan.nextInt();
		
		count ++; 
		System.out.println("=> 등록 완료!!");
		
		System.out.print("계속 등록(아무키), 종료(n)? > ");
		if(scan.next().equals("n")) {
			showMenu();
		} else {
			insert();
		}
	}
	public void showList() {
		if(count != 0) {
		System.out.println("-------------------------------------------");
		System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("-------------------------------------------");
		int i = 0;
		for(Student student : sList) {
			if(i < count) {
		System.out.print(student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\t\n");
			}
			i++;
		}
		System.out.println("-------------------------------------------");
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해 주세요");
		}
	}
	
	public void search() {
		
			        System.out.print("학생명 검색 > ");
			        String searchName = scan.next();
			        int searchIdx = -1;
			        for(int i = 0;  i<count; i++) {
			        	Student student = sList[i];
			        	if (student.name.equals(searchName)) searchIdx = i;			        
			        	}			        
			        if(searchIdx != -1) {
				        System.out.println("검색결과 주소 : " + searchIdx);
				        System.out.println("---------------------------------------------");
				        System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
				        System.out.print(sList[searchIdx].name+"\t");
				    	System.out.print(sList[searchIdx].kor+"\t");
				     	System.out.print(sList[searchIdx].eng+"\t");
				    	System.out.print(sList[searchIdx].math+"\t");
				    	System.out.print(sList[searchIdx].getTot()+"\t");
				    	System.out.print(sList[searchIdx].getAvg()+"\n");
				    	
				    	System.out.println("---------------------------------------------");
			        
			            System.out.print("계속 검색 하시겠습니까?(계속:아무키나누르세요, 종료:n))");            
			        	if(scan.next().equals("n")) showMenu(); 
			        	else search();
		                
			        } else {
			        	System.out.println("=> 등록된 데이터 없음, 등록부터 진행해주세요");
			        }
	}
	
	
    public void update() {
    	 
    	        System.out.print("[수정]학생명 검색 > ");
    	        String modifiedName = scan.next();
    	        int modiIdx = -1;
    	       

    	        for (int i = 0; i < count; i++) {
    	            if (sList[i].name.equals(modifiedName)) {
    	                modiIdx = i;
    	                break;
    	            }
    	        }

    	        if (modiIdx == -1) {
    	            System.out.println("수정할 데이터가 존재하지 않습니다. 다시 입력해주세요.");
    	        } else {
    	            System.out.print("국어 > ");
    	            sList[modiIdx].kor = scan.nextInt();
    	            System.out.print("영어 > ");
    	            sList[modiIdx].eng = scan.nextInt();
    	            System.out.print("수학 > ");
    	            sList[modiIdx].math = scan.nextInt();

    	            sList[modiIdx].Tot = sList[modiIdx].kor + sList[modiIdx].eng
    	            + sList[modiIdx].math;
    	            sList[modiIdx].Avg = sList[modiIdx].Tot / 3;

    	            System.out.println("=> 수정 완료!!");
    	            
    	            System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
    	            System.out.print(sList[modiIdx].name+ "\t");    
    	            System.out.print(sList[modiIdx].kor+ "\t");
    	            System.out.print(sList[modiIdx].eng+ "\t");
    	            System.out.print(sList[modiIdx].math+ "\t");
    	            System.out.print(sList[modiIdx].Tot+ "\t");
    	            System.out.print(sList[modiIdx].Avg+"\n");
    	        }
    	     

    	        System.out.print("계속 수정 하시겠습니까?(계속: 아무 키나, 종료: n) > ");
    	        if(scan.next().equals("n")) showMenu(); 
    	        else update();
        
    }
  
    
    public void remove() {
    	System.out.println("[삭제] 학생명 검색 > ");
		String deleteName = scan.next();
		int deleteIdx = -1;
		for(int i = 0; i <count; i++) {
			if(sList[i].name.equals(deleteName)) deleteIdx = i;
		}
		
		if(deleteIdx != -1) {
		for(int i =deleteIdx; i < count-1; i++) {	
			  sList[i].name = sList[i+1].name;                                  
			  sList[i].kor = sList[i+1].kor;                                 
			  sList[i].eng = sList[i+1].eng;                                 
			  sList[i].math = sList[i+1].math;                                  
			  sList[i].Tot = sList[i+1].Tot;                                 
			  sList[i].Avg = sList[i+1].Avg;  
			  //sList[i] = sList[i+1];
			  //카운트 -- 위에 sList[count-1] = null; 작성가능
			  
   			}
          		count --;
          	  System.out.println("삭제 완료");
		      System.out.print("계속 삭제 하시겠습니까?(계속:아무키나누르세요, 종료:n))");
	        	
	        	if(scan.next().equals("n")) showMenu();
	        	else remove();
	      
	        	
		} else {
		    System.out.println("삭제할 데이터가 존재X, 다시 입력해주세요");	
		}
	}

}

package chpater07;

import java.util.Scanner;

public class ScoreMgmSystem {
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	
	public ScoreMgmSystem() {
		
	}
	public void insert() {
		student = new Student();
		System.out.println("--insert--");
		System.out.print("학생명 > ");
		student.name = scan.next();
		
		System.out.print("국어점수 > ");
		student.kor = scan.nextInt();
		
		System.out.print("영어점수 > ");
		student.eng = scan.nextInt();
		
		System.out.print("수학점수 > ");
		student.math = scan.nextInt();
		
		System.out.println("=> 등록 완료!!");
		
	}
	public void show() {
		System.out.println("-------------------------------------------");
		System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("-------------------------------------------");
		System.out.print(student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\t\n");
		System.out.println("-------------------------------------------");
	}
	
	
    public void update() {
		System.out.println("수정");
	}
    public void remove() {
    	System.out.println("삭제");
	}
    public void search() {
    	System.out.println("검색");
	}

}

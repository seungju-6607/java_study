package chapter07;

public class Student {
	String name;
	int kor, eng, math;
	int Tot; int Avg;
	
	
	
	

    public Student () {
    	
    }
    public int getTot() {
    	return kor + eng + math;
    }
    public int getAvg() {
    	return (kor + eng + math)/3;
    }
}
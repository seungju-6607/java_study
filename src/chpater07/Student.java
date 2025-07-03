package chpater07;

public class Student {
	String name;
	int kor, eng, math;
	
	
	
	

    public Student () {
    	
    }
    public int getTot() {
    	return kor + eng + math;
    }
    public int getAvg() {
    	return (kor + eng + math)/3;
    }
}
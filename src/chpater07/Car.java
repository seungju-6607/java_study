package chpater07;

public class Car {
    //Field = 필드변수, 멤버변수, 전역변수
	String name;
	String company;
	int price;
	
	//Constructor
	//Method
	public void showInfo() {
		System.out.print(name + "\t");
		System.out.print(company +"\t");
		System.out.println(price);
	}
}

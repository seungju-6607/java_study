package vending_machine_ver1;

public class RestArea {
	String name;
	User user;
	VendingMachine machine;	
	
	public RestArea() {
		this("만남의 광장");
	}
	public RestArea(String name) {
		this.name = name; // 확장을 위해 사용한다.
		user = new User("정국");
		welcome();		
		machine = new VendingMachine(user);
	}
	
	public void welcome() {
		System.out.println("---------------------------------------------");
		System.out.println(name + " ☕🍵🥤  휴게소에 오신것을 환영합니다");
		System.out.println("---------------------------------------------");
	}
	
	
}
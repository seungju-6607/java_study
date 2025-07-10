package chapter07;

/*
 * 싱글톤 디자인 패턴 적용
 */

public class Singleton {
	//필드
	private static Singleton singleton = new Singleton();
	private String name;
	
	//생성자
	private Singleton() {
		
	}
	
	//메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Singleton getInstance() {
		return singleton;
	}

}

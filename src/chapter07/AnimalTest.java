package chapter07;

public class AnimalTest {

	public static void main(String[] args) {
		System.out.println("--AnimalTest 클래스 실행!!! --");
	
        //사자, 호랑이 객체 생성
		Animal lion = new Animal();
		Animal tiger = new Animal();
		
		Animal giraffe = new Animal();
    	Animal elephant = new Animal();
    	
    	giraffe.name = "기린이";
    	elephant.name = "코순이";
		
		lion.name = "심바";
		lion.age = 5;
		
		tiger.name = "호돌이";
		tiger.age = 3;
		
		System.out.println("lion.name = " + lion.name);
		System.out.println("lion.age = " + lion.age);
		
		System.out.println("tiger.name = " + tiger.name);
		System.out.println("tiger.age = " + tiger.age);
		
		System.out.println("giraffe.name = " + giraffe.name);
		System.out.println("elephant.name = " + elephant.name);
		
	
		lion.sleep();
		tiger.sleep();
	}

}

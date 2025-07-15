package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowc = new Circle("노랑",1);
		Rectangle blueR = new Rectangle("파랑", 1,2);
		
		Shape s = new Circle("초록색", 2); //자동형변환
		Circle cs = (Circle)s; //강제(명시적) 형변환 o
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2; //강제(명시적) 형변환 X
		
		
		
	    ShapeInterface si = new Circle("코랄", 1);
	    si.draw(); //자식인 Circle의 draw() 호출됨
	    System.out.println(si.getArea());
	    System.out.println();
	    Circle cs3 = (Circle)si;
	    cs3.draw();
	    System.out.println(cs3.getArea());
	    //상속받은 인터페이스 통한 객체 생성
	    //사각형, 삼각형
	    
	    ShapeInterface si2 = new Rectangle("초록",1,2);
	    ShapeInterface si3 = new Triangle("노랑");
	    si2.draw();
		si3.draw();


	}

}

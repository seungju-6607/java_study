package chapter04;

/*
 * 논리연산자 : &&(AND), ||(OR), !(not)
 * &&, || 연산자는 앞의 식의 결과에 따라 shortcut으로 진행됨
 */
public class OpLogicTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우에만 실행결과가 true
		System.out.println((a > b) && (a == 10)); //true
		System.out.println((a > b) && (b == 10)); //false
		System.out.println((a < b) && (a == 10)); //false
		System.out.println((a < b) && (b == 10)); //false
		
		System.out.println("");//띄어쓰기
		
		// OR(||) : 두 개의 항의 결과가 하나라도 true이면 실행결과가 true
		System.out.println((a > b) || (a == 10)); //true
		System.out.println((a > b) || (b == 10)); //true
		System.out.println((a < b) || (a == 10)); //true
		System.out.println((a < b) || (b == 10)); //false

        System.out.println("");//띄어쓰기
		
		// NOT(!) : 결과물 반대의 BOOLEAN 값으로 변경
		System.out.println(!(!(a > b) || !(a == 10))); //true
//		System.out.println(!a); //a는 int 타입으로 NOT 연산자가 적용되지 않음
		

		
	}

}

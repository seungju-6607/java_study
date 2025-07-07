package chapter07;

public class ArithMeticTest {

	public static void main(String[] args) {
		ArithMetic arithmetic = new ArithMetic();
		ArithmeticOverloading arithmetic_ol= new ArithmeticOverloading();
		
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(10,20));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(3.14,1.5));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("100","200"));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(1,2,3,4,5,6,7,8,9,10));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("1","2","3","4","5","6","7","8","9","10"));
		
		int add = arithmetic.add(10, 20);
		int sub = arithmetic.sub(10, 20);
		double mul = arithmetic.mul(3.14, 10);
		int div = arithmetic.div(10, 20);
		int mod = arithmetic.mod(10, 20);

		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod);
	}

}

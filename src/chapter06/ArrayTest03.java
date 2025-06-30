package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {
		// 1에서 5까지의 데이터를 저장 후 순서대로 출력
		int[] numbers = new int[5]; //배열의 전체 크기 : 변수명.length

		//데이터 저장 및 출력
		for (int i = 0 ; i < numbers.length; i++) {
			numbers[i] = i + 1; //number[0] = 1;
			System.out.println(numbers[i]);
		}
		

		
		
		
	
	}

}

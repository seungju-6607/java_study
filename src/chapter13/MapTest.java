package chapter13;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

 	public static void main(String[] args) {
		Map<Integer, String> subjects = new HashMap<Integer, String> ();
		
		//1. 데이터 저장 : C(Crate)
		subjects.put(1,"java");
		subjects.put(2,"mysql");
		subjects.put(3,"html");
		
		
		//2. 데이터 출력 : R(Read)
//		subjects.forEach(System.out::println); //클래스 참조 형식의 람다코드는 사용X
		subjects.forEach((key,value) -> System.out.println(key +"." + value)); 
		
		//3. 데이터 수정 : U(Update)
		if(subjects.containsKey(2)) subjects.put(2,"oracle");
		
		System.out.println();
		subjects.forEach((key,value) -> System.out.println(key + "," + value)) ;

		
		//4. 데이터 삭제 : D(Delete)
		subjects.remove(2);
		System.out.println();
		subjects.forEach((key,value) -> System.out.println(key + "," + value));
		subjects.clear();
		System.out.println("--전체 삭제 완료--");
		subjects.forEach((key,value) -> System.out.println(key + "," + value));
	}

}

package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		name2 = "welcomeToJava!!";
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
        String[] phones = phone.split("-");
        String[] subjects = subject.split(",");
        
        String jphone = String.join("-",phones);
        
        System.out.println(subject.contains("html"));
        System.out.println(jphone);
        System.out.println(subjects[0]);
        System.out.println(phones[0]);
		System.out.println(name2.substring(7,10)); //원하는 글자 보여주기
		System.out.println(name2.substring(7)); //원하는 글자 보여주기
		System.out.println(name2.length()); //글자갯수
	    System.out.println(name2.toUpperCase()); //모두대문자
	    System.out.println(name2.toLowerCase()); //모두소문자
		System.out.println(num);
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
		if(name1 == name2) {
			System.out.println("true");
		} else {
			System.out.println("다름");
		}
		if(name1.equals(name2)) System.out.println("동일");
		else System.out.println("다름");

	}

}

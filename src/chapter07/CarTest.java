package chapter07;

public class CarTest {

	public static void main(String[] args) {
		
		Car avante = new Car();
		Car ev6 = new Car();
        avante.name = "아반테";
        avante.company = "현대자동차";
        avante.price = 1000;
        
   
        ev6.name = "EV6";
        ev6.company = "기어자동차";
        ev6.price = 2000;
        
        System.out.println("**************************");
        System.out.println("\tCar Information");
        System.out.println("**************************");
        //각 메소드 호출 종료 시 main으로 돌아가는 복귀주소(리턴주소)를 갖는다.
        avante.showInfo();
        ev6.showInfo();
        System.out.println("--main 메소드 종료 --");
	}

}

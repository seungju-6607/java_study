package lunch;

public class LunchOrderSystemOOPTest {

	public static void main(String[] args) {
		LunchOrderSystemOOP system = new LunchOrderSystemOOP();
		system.title = "더조은";
		system.showMainMenu();
		
		new LunchOrderSystemOOP("HAPPY");
	}

}
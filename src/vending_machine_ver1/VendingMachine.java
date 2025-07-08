package vending_machine_ver1;
import commons.Menu;
public class VendingMachine {
	
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유 ",};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	
	public VendingMachine() {
		createMenuList();
	}

	/*
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		for(int i =0; i <nameList.length; i++) {
			Menu menu = new Menu((i+1));
			int no = i + 1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			
		}
	}
}

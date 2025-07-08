package drink;

public class Order {
    //Field
	Menu orderMenu;
	
    //Constructor
	public Order() {}
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	//Method
	public void getInfo() {
        
		System.out.printf("=> 주문 메뉴 : " + orderMenu.name + ", "
				+ "결제 예정 금액 : %,d원\n",orderMenu.price);
	}
	
	public String getName() {
		return orderMenu.name;
	}
	
	public int getTotal() {
		return orderMenu.price;
	}
}

package drink;

public class Menu {
	String name;
	int price;
	int no;
	
	public Menu() {}
	public Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
    public String getName() {
    	return name;
    }
    public int getPrice() {
    	return price;
    }
    public int getNo() {
    	return no;
    }
}

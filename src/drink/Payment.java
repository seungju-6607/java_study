package drink;

public class Payment {
	//필드
	int amount;
	int change;
	
	//생성자
	public Payment() {}
	
	//메소드
	public void setAmount(int amount) {
		this.amount += amount;
	}
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getPayment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			result = true;
		}
		
		return result;
	}
	
}

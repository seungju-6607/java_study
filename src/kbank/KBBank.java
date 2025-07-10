package kbank;

public class KBBank {

	public static void main(String[] args) {
		//입출금 용지 한장 비치됨
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		BankMan staffPark = new BankMan("박보검");
		staffPark.showAccountList();
		
		Customer hong = new Customer("홍길동","kb-1234","1234",100);
		
		hong.setAccountPaper(accountPaper);
		System.out.println("2 ----> " + accountPaper.getName());
		
		staffPark.checkPaper(hong.getAccountPaper(),hong);
		staffPark.askMoney(hong.answerMoney());
		staffPark.check();
		staffPark.changeProcess();
		hong.confirmBalance();

		
	}

}

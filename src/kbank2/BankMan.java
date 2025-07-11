package kbank2;

public class BankMan {

	String name;
	int checkResult;
	private AccountPaperVo accountPaper;
	private AccountVo[] accountList;	
	private BankSystem kbsystem;
	
	public static final  int ACCOUNT_NAME = 1;
	public static final  int ACCOUNT_NUMBER = 2;
	public static final  int ACCOUNT_PASSWORD = 3;
	public static final  int ACCOUNT_MONEY = 4;
	
	public BankMan() {}
	public BankMan(String name ,BankSystem kbsystem) {
		this.name ="[은행직원 : " + name + "]";
		this.kbsystem = kbsystem;
		System.out.print(this.name + "업무 시작!! \n");
	
	}
	/**
	 * 고객의 출금정보 유효성 체크 결과에 따라 질문
	 */
	public void ask(int status) {
		
		switch(status) {
			case ACCOUNT_NAME : 
				System.out.println(this.name + " 이름을 입력해주세요!!");
				checkResult = ACCOUNT_NAME;
				break;
			case ACCOUNT_NUMBER :
				System.out.println(this.name + " 계좌번호를 입력해주세요!!");
				checkResult = ACCOUNT_NUMBER;
				break;
			case ACCOUNT_PASSWORD :
				System.out.println(this.name + " 비밀번호를 입력해주세요!!");
				checkResult = ACCOUNT_PASSWORD;
				break;
			case ACCOUNT_MONEY :
				System.out.println(this.name + " 금액을 입력해주세요!!");
				checkResult = ACCOUNT_MONEY;
				break;
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크! 
	 */
	public void validateCheck() {
		System.out.println("[은행직원:"+ name + "] 고객 정보에 대한 유효성 체크를 진행한다.");
		
		if(accountPaper.getName() == null) {
			ask(ACCOUNT_NAME);
		} else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		} else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		} else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		} else {
							
		}
		
	
		
		
	}
	
	public boolean validateCheck(AccountPaperVo updateAccountPaper) {
		 
		    System.out.println("[은행직원:" + name + "] 고객 정보에 대한 유효성 체크를 재진행한다.");
		    this.accountPaper = updateAccountPaper;

		    boolean result = true;

		    if (accountPaper.getName() == null) {
		        ask(ACCOUNT_NAME);
		        result = false;
		    } 
		    if (accountPaper.getAccountNumber() == null) {
		        ask(ACCOUNT_NUMBER);
		        result = false;
		    } 
		    if (accountPaper.getPassword() == null) {
		        ask(ACCOUNT_PASSWORD);
		        result = false;
		    } 
		    if (accountPaper.getMoney() == 0) {
		        ask(ACCOUNT_MONEY);
		        result = false;
		    }

		    if (result) {
		        System.out.println(this.name + " 모든 정보가 유효합니다.");
		    }

		    return result;
		}

		
	
	public void processWithdrawal() {
		System.out.println(this.name + "출금요청 처리 진행 중입니다. 잠시만 기다려주세요.");
		int accountIdx = kbsystem.searchAccount(accountPaper);	
		if(accountIdx != -1) {
			AccountVo account = kbsystem.accountList[accountIdx];
			if(account.getBalance() >= accountPaper.getMoney()) {
			//출금 진행 후 계좌 업데이트!!!
				int money = account.getBalance() - accountPaper.getMoney();
				account.setBalance(money);	
				kbsystem.accountList[accountIdx] = account;
				
				processCompleted();
			}else {
				System.out.println(this.name + "잔액이 부족합니다.");
			}
		} else {
			System.out.println(this.name + "계좌정보가 일치하지 않습니다. 확인후 다시 진행해주세요.");
		}
	
	}
	
	
	public void processCompleted() {
	    System.out.println(this.name + " 출금이 완료되었습니다!");
	    System.out.println(this.name + "금액: " + accountPaper.getMoney() + "입니다");
	    
	}
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(this.name + "고객에게 출금용지 받음!");
	}
	public AccountVo[] getAccountList() {
		return accountList;
	}
	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}
	public BankSystem getKbsystem() {
		return kbsystem;
	}
	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}
	
	
	
}

package kbank;

import java.util.Scanner;

public class Customer {
    private String name;
    private String accountNumber;
    private String password;
    private int money;
    private  AccountPaperVo accountPaper;
    private Scanner scan;

    public Customer() {}
    
    public Customer(String name, String accountNumber, String password, int money) {
    	scan = new Scanner(System.in);
        this.name = name;
        this.accountNumber = accountNumber;  
        this.password = password;
        this.money = money;
    }
    public AccountPaperVo getAccountPaperVo() {
    	return accountPaper;
    }
    public void setAccountPaper(AccountPaperVo accountPaper) {
    	this.accountPaper = accountPaper;
    	this.accountPaper.setName(this.name);
    	this.accountPaper.setAccountNumber(this.accountNumber);
    	this.accountPaper.setPassword(this.password);
    	this.accountPaper.setMoney(this.money);
    }

    
    
    
    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

    
}

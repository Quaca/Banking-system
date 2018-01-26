package assignment2;

public class Customer {
	private String name;
	private String address;
	private String phone;
	private String password;
	private double balance = 0;
	private int accountNumber;
	private boolean accountBlocked = false;
	private static int members = 0;
	
	Customer(String name, String address, String phone, String password, double amount, int accountNumber) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.balance = amount;
		this.accountNumber = accountNumber;
		members++;
		
	}
	
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getPassword() {
		return this.password;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.balance;
	}
	public static int getMembers() {
		return members;
	}
	public boolean getAccountBlocked() {
		return accountBlocked;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBalance(double amount, boolean deposit) {
		
		if (deposit) {
			this.balance += amount;
		}
		else {
			this.balance -= amount;
		}
		
	}
	public void setAccountNumber() {
		this.accountNumber = members;
		members++;
	}
	public void setAccountBlocked() {
		this.accountBlocked = true;
	}
	
}

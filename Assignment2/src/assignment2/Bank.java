package assignment2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bank{
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	
	public void setCustomer(String name, String address, String phone, String password, double amount, int accountNumber) {
		Customer customer = new Customer(name, address, phone, password, amount, accountNumber);
		customers.add(customer);
		
	}
	
	public void setPassword(String newPassword, int accID) {
		customers.get(accID).setPassword(newPassword);
	}
	
	public boolean deposit(double amount, int i){

	    if (amount<=0) {
	         return false;
	    } 
	    else {
	    	 customers.get(i).setBalance(amount, true);
	    	 return true;
	    }
	}
	public boolean withdraw(double amount, int i){	        
	    if (amount<=0){
	    	return false;
	    }
	    else{
		    if (customers.get(i).getBalance() < amount) {
			    return false;
		    } 
		    else {
			    customers.get(i).setBalance(amount, false);
			    return true;
		    }
	    }
	}
	public void print(int accID) {
		JOptionPane.showMessageDialog(null, "Name: " + customers.get(accID).getName() + "\nAddress: " 
				+ customers.get(accID).getAddress() + "\nPhone: " + customers.get(accID).getPhone()
			+ "\nBalance: " + customers.get(accID).getBalance() + "\nAccountNumber: " + customers.get(accID).getAccountNumber());
	}
	
}

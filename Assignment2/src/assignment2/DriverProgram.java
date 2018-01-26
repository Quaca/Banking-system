package assignment2;

import java.util.ArrayList;

import javax.swing.JOptionPane; 


public class DriverProgram {
	public static void main(String[] args) {
		int choice;
		int accID;
		String accPassword;
		Bank bank = new Bank();
		
		
		
		while(true) {
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("1.New account\n" + "2.Operations\n" + "3.Exit\n"));
			while(choice > 3 || choice < 1) {
				choice = Integer.parseInt(JOptionPane.showInputDialog("You have entered wrong number. Try again\n" + "1.New account\n" + "2.Operations\n" + "3.Exit\n"));
			}
			if (choice == 1) {
				
				String name = JOptionPane.showInputDialog("Your name");
				String address = JOptionPane.showInputDialog("Address");
				String phone = JOptionPane.showInputDialog("Phone");
				String password = JOptionPane.showInputDialog("Password");
				String rePassword = JOptionPane.showInputDialog("Re-enter password");
				while(!password.equals(rePassword)) {
					rePassword = JOptionPane.showInputDialog("There is a mistake in re-typing a password\n" + "Re-type password");
				}
				double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial amount"));
				int accountNumber = Customer.getMembers();
				
				bank.setCustomer(name, address, phone, password, balance, accountNumber);
				
				JOptionPane.showMessageDialog(null,"Your account has successfully completed as: \n" + "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone
						+ "\nInitial amount: " + balance + "\nAccountNumber: " + accountNumber + "\n do not forget your account number and password");
				
				
			}
			else if (choice == 2) {
				
				int wrongPasswords = 0;
				int operations;
				int amount;
				boolean correctID = false;
				boolean correctPassword = false;
				
				ArrayList<Customer> customers = bank.getCustomers();
				int members = Customer.getMembers();
				accID = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number: \n"));
				
				while(accID >= members || accID < 0) {
					accID = Integer.parseInt(JOptionPane.showInputDialog("ID doesn't exist \nEnter your account number: \n"));
				}
				
				
				if (customers.get(accID).getAccountBlocked() == true) {
					JOptionPane.showMessageDialog(null, "Your account has been blocked");
					continue;
				}
				
				while(correctID == false) {
					for(int i = 0; i < members; i++) {
						if(accID == customers.get(i).getAccountNumber()) {
							correctID = true;
							break;
						}
					}
					if(correctID == false) {
						accID = Integer.parseInt(JOptionPane.showInputDialog("ID doesn't exist \n" +"Enter your account number: "));
					}
				}
				
				accPassword = JOptionPane.showInputDialog("Enter your password: ");
				
				while(correctPassword == false) {
										
					if(accPassword.equals(customers.get(accID).getPassword())) {
						correctPassword = true;
					}
					else {
						accPassword = JOptionPane.showInputDialog("Password incorrect \n" + "Enter your password: ");							
						wrongPasswords++;
					}
					if (wrongPasswords == 2) {
						customers.get(accID).setAccountBlocked();
						JOptionPane.showMessageDialog(null, "Your account is blocked since your password is wrong!!! Call the bank immediately	");
						break;
					}
				}
				
				if (customers.get(accID).getAccountBlocked() == true) {
					continue;
				}
					
				
				
				operations = Integer.parseInt(JOptionPane.showInputDialog("Select your operations from the menu\n	1. Change password\n2. Deposit\n3. Withdraw\n4. Print\n5. Exit"));
				
				while(operations > 5 || operations < 1) {
					operations = Integer.parseInt(JOptionPane.showInputDialog("Wrong input\nSelect your operations from the menu\n	1. Change password\n2. Deposit\n3. Withdraw\n4. Print\n5. Exit"));
				}
				
				while (operations != 5) {
				
				if(operations == 1) {
				
					String password = JOptionPane.showInputDialog("Password");
					String rePassword = JOptionPane.showInputDialog("Re-enter password");
					while(!password.equals(rePassword)) {
						rePassword = JOptionPane.showInputDialog("There do not match\n" + "Re-type password");
					}
					bank.setPassword(rePassword, accID);
					JOptionPane.showMessageDialog(null, "Operation successful");

				}
				
				else if(operations == 2){
					amount = Integer.parseInt(JOptionPane.showInputDialog("Amount to deposit"));
					while(bank.deposit(amount, accID) == false) {
						amount = Integer.parseInt(JOptionPane.showInputDialog("Amount should be positive\nEnter again amount of money you want to deposit"));
					}
					JOptionPane.showMessageDialog(null, "Operation successful");
				}
				
				else if(operations == 3) {
					amount = Integer.parseInt(JOptionPane.showInputDialog("Amount to withdraw"));
					while (bank.withdraw(amount, accID) == false) {
						amount = Integer.parseInt(JOptionPane.showInputDialog("Wrong input\n Enter again amount of money you want to withdraw"));
					}
					JOptionPane.showMessageDialog(null, "Operation successful");
					
				}
				else if(operations == 4) {
					bank.print(accID);
				}
				
				operations = Integer.parseInt(JOptionPane.showInputDialog("Select your operations from the menu\n	1. Change password\n2. Deposit\n3. Withdraw\n4. Print\n5. Exit"));
				
				while(operations > 5 || operations < 1) {
					operations = Integer.parseInt(JOptionPane.showInputDialog("Wrong input\nSelect your operations from the menu\n	1. Change password\n2. Deposit\n3. Withdraw\n4. Print\n5. Exit"));
				}
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Operations done");
				break;
			}
			
		}
	}
}

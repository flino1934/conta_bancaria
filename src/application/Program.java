package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Account;
import entities.BusinessAccount;
import entities.CheckingAccount;
import entities.SavingsAccount;
import entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		List<Account> accounts = new ArrayList<>();
		try {
			int n = Integer.parseInt(JOptionPane.showInputDialog("Number of accounts"));

		
			for (int i = 1; i <= n; i++) {

				int number = Integer.parseInt(JOptionPane.showInputDialog("Number account"));
				String holder = JOptionPane.showInputDialog("Holder: ");
				double balance = Double.parseDouble(JOptionPane.showInputDialog("Balance: "));
				double amount;

				String[] select = { "Savings account", "Business account", "Checking acconut" };
				String type = (String) JOptionPane.showInputDialog(null, "Select... ", "Select type account: ",
						JOptionPane.QUESTION_MESSAGE, null, select, select[0]);

				if (type.equals("Savings account")) {// Começo da Savings account

					double interestRate = Double.parseDouble(JOptionPane.showInputDialog("Interest Rate"));

					Account acc = new SavingsAccount(number, holder, balance, interestRate);
					accounts.add(acc);

					for (Account account : accounts) {
						System.out.println("----------Savings Account----------");
						System.out.println(account);
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of deposit"));
					acc.deposit(amount);

					for (Account account : accounts) {
						System.out.println("----------Deposit----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of withdraw"));
					acc.withdraw(amount);
					for (Account account : accounts) {
						System.out.println("----------withdraw----------");
						System.out.println(account);
						System.out.println();
					}

				} // Fim da savings account

				if (type.equals("Business account")) {// Começo da business account

					double loanLimit = Double.parseDouble(JOptionPane.showInputDialog("Loan limit: "));

					Account acc = new BusinessAccount(number, holder, balance, loanLimit);
					accounts.add(acc);
					
					for (Account account : accounts) {
						System.out.println("----------Business Account----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of deposit"));
					acc.deposit(amount);

					for (Account account : accounts) {
						System.out.println("----------Deposit----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of withdraw"));
					acc.withdraw(amount);
					for (Account account : accounts) {
						System.out.println("----------withdraw----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Enter value of loan"));
					BusinessAccount b = (BusinessAccount) acc;// Foi feito downCasting para ter acesso ao metodo loan
					b.loan(amount);

					for (Account account : accounts) {
						System.out.println("----------pos----------");
						System.out.println(account);
						System.out.println();
					}

				}//Fim da BusinessAccount
				
				if (type.equals("Checking acconut")) {//Começo da Checking acconut
					double limitWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Enter value of limit withdraw"));
					Account acc = new CheckingAccount(number, holder, balance, limitWithdraw);
					accounts.add(acc);
					
					for (Account account : accounts) {
						System.out.println("----------Checking Account----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of deposit"));
					acc.deposit(amount);

					for (Account account : accounts) {
						System.out.println("----------Deposit----------");
						System.out.println(account);
						System.out.println();
					}

					amount = Double.parseDouble(JOptionPane.showInputDialog("Value of withdraw"));
					acc.withdraw(amount);
					for (Account account : accounts) {
						System.out.println("----------withdraw----------");
						System.out.println(account);
						System.out.println();
					}
				}

			}

		} catch (DomainException e) {
			System.out.println("Error :"+e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Error unexpetd");
		}
	}
}

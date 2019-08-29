package entities;

import entities.exceptions.DomainException;

public class BusinessAccount extends Account {//vai herdar a classe Account que é abstrata

	private Double loanLimit;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) {

		loanLimit -= amount;
		balance += amount;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0) {

			throw new DomainException("deposit has to be higher 0");
			//O deposito tem que ser maior que 0
		}

		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance) {

			throw new DomainException("withdrawal amount exceeded");
			//Se o saque for maior que o valor em conta vai retornar um erro
		}
		balance -= amount + 5.0;

	}

	@Override
	public String toString() {

		return "Number: " + getNumber() + " Holder: " + getHolder() + "\nBalance: " + getBalance() + " R$"
				+ " Loan Limit: " + loanLimit + " R$";
	}

	//Essa classe é responsavel pelas ações da conta empresarial
}

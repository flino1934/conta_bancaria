package entities;

import entities.exceptions.DomainException;

public class SavingsAccount extends Account {// vai herdar a classe Account que é abstrata

	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void deposit(double amount) {

		if (amount <= 0) {
			throw new DomainException("deposit has to be higher 0");
		}

		balance += (amount) + balance * interestRate;
		//Toda vez que for depositado o dinheiro vai ser feito um recalculo aplicando a taxa de juros

	}

	@Override
	public void withdraw(double amount) {

		if (amount > balance) {

			throw new DomainException("withdrawal amount exceeded");
			// Se o saque for maior que o valor em conta vai retornar um erro
		}
		balance -= amount;

	}

	@Override
	public String toString() {

		return "Number acccount: " + getNumber() + " Holder: " + getHolder() + "\nBalance:" + getBalance()
				+ " interest Rate: " + interestRate + "%";

	}

	// Essa classe é responsavel pelas ações da conta poupança

}

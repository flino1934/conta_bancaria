package entities;

import entities.exceptions.DomainException;

public class CheckingAccount extends Account {//vai herdar a classe Account que é abstrata

	private Double limitWithdraw;

	public CheckingAccount() {
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(Integer number, String holder, Double balance, Double limitWithdraw) {
		super(number, holder, balance);
		this.limitWithdraw = limitWithdraw;
	}

	public Double getLimitWithdraw() {
		return limitWithdraw;
	}

	public void setLimitWithdraw(Double limitWithdraw) {
		this.limitWithdraw = limitWithdraw;
	}

	@Override
	public void deposit(double amount) {

		if (amount <= 0) {

			throw new DomainException("deposit has to be higher 0");
			// O deposito tem que ser maior que 0
		}

		balance += amount;

	}

	@Override
	public void withdraw(double amount) {

		if (amount > balance) {

			throw new DomainException("withdrawal amount exceeded");
			// Se o saque for maior que o valor em conta vai retornar um erro
		}

		if (amount > limitWithdraw) {
			throw new DomainException("withdrawal amount exceeded limit withdrawal");
			//excede o valor de limit
		}
		balance -= amount + 2.0;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Number acccount: " + getNumber() + " Holder: " + getHolder() + "\nBalance:" + balance
				+ " Limit withdraw: " + limitWithdraw + "R$";
		
	}

}//Essa classe vai cuidar da conta corrente aplicando suas operações 

package entities;

public abstract class Account {//� uma classe abstrata pq todos os outros tipos de conta tamb�m s�o conta

	private Integer number;
	private String holder;
	protected Double balance;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Integer number, String holder, Double balance) {

		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public abstract void deposit(double amount);//Metodo abstrato que as outras classes v�o implementar

	public abstract void withdraw(double amount);//Metodo abstrato que as outras classes v�o implementar

	public abstract String toString();//Metodo abstrato que as outras classes v�o implementar
}

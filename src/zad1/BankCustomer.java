package zad1;

public class BankCustomer{
	Account konto;
	String CustomerName;

	public BankCustomer(Person p) {
		this.konto = new Account(0.0);
		this.CustomerName=p.getName();
	}
	
	public Account getAccount (){
		return konto;
	}

	@Override
	public String toString() {

		return "Klient: "+CustomerName+" stan konta " + konto.getBalance();
	}
}

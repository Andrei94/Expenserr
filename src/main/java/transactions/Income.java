package transactions;

public class Income {
	public int amount;
	public String name;
	public String currency;

	public Income() {
		this("", 0, "usd");
	}

	public Income(String name, int amount, String currency) {
		this.name = name;
		this.amount = amount;
		this.currency = currency;
	}
}

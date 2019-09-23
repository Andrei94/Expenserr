package transactions;

public class Income {
	public int amount;
	public String name;
	public String currency;
	public int dayOfIncome;

	public Income() {
		this("", 0, "usd", 1);
	}

	public Income(String name, int amount, String currency, int dayOfIncome) {
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.dayOfIncome = dayOfIncome < 1 ? 1 : Math.min(dayOfIncome, 31);
	}
}

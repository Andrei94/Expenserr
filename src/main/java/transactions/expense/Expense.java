package transactions.expense;

public class Expense {
	public int amount;
	public String name;
	public String currency;
	public int dayOfExpense;

	public Expense() {
		this("", 0, "usd", 1);
	}

	public Expense(String name, int amount, String currency, int dayOfExpense) {
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.dayOfExpense = dayOfExpense < 1 ? 1 : Math.min(dayOfExpense, 31);
	}
}

package transactions.income.service;

import transactions.income.model.Income;

public class IncomeService {
	private final IncomeDAO incomeDAO;
	private int totalAmount = 0;

	public IncomeService(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public boolean add(String name, int amount, String currency, int dayOfIncome) {
		incomeDAO.add(new Income(name, amount, currency, dayOfIncome));
		totalAmount += amount;
		return true;
	}

	public int getTotalAmount() {
		return totalAmount;
	}
}

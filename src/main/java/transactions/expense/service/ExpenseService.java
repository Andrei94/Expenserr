package transactions.expense.service;

import transactions.expense.model.Expense;

public class ExpenseService {
	private final ExpenseDAO expenseDAO;
	private int totalAmount;

	public ExpenseService(ExpenseDAO expenseDAO) {
		this.expenseDAO = expenseDAO;
	}

	public boolean add(String name, int amount, String currency, int dayOfExpense) {
		expenseDAO.add(new Expense(name, amount, currency, dayOfExpense));
		totalAmount += amount;
		return true;
	}

	public int getTotalAmount() {
		return totalAmount;
	}
}

package transactions.balance.service;

import transactions.expense.service.ExpenseService;
import transactions.income.service.IncomeService;

public class BalanceCalculator {
	private final IncomeService incomes;
	private final ExpenseService expenses;

	public BalanceCalculator(IncomeService incomes, ExpenseService expenses) {
		this.incomes = incomes;
		this.expenses = expenses;
	}

	public int calculate() {
		return incomes.getTotalAmount() - expenses.getTotalAmount();
	}
}

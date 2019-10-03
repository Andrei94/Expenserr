package transactions.expense.service;

import transactions.expense.model.Expense;

public interface ExpenseDAO {
	int size();

	void add(Expense expense);
}

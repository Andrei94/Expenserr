package transactions.expense.dao;

import transactions.expense.service.ExpenseDAO;
import transactions.expense.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOInMemory implements ExpenseDAO {
	private List<Expense> expenses = new ArrayList<>();

	@Override
	public void add(Expense expense) {
		if(expense != null)
			expenses.add(expense);
	}

	@Override
	public int size() {
		return expenses.size();
	}
}

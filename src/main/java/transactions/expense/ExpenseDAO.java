package transactions.expense;

public interface ExpenseDAO {
	int size();

	void add(Expense expense);
}

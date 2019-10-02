package transactions.income.service;

import transactions.income.model.Income;

public interface IncomeDAO {
	void add(Income income);

	int size();
}

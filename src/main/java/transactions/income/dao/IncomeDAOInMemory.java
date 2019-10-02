package transactions.income.dao;

import transactions.income.service.IncomeDAO;
import transactions.income.model.Income;

import java.util.ArrayList;
import java.util.List;

public class IncomeDAOInMemory implements IncomeDAO {
	private List<Income> incomes = new ArrayList<>();

	@Override
	public void add(Income income) {
		if(income != null)
			incomes.add(income);
	}

	@Override
	public int size() {
		return incomes.size();
	}
}

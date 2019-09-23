package transactions;

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

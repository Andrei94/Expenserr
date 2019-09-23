package transactions;

public class IncomeController {
	private final IncomeDAO incomeDAO;

	public IncomeController(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public boolean add(String name, int amount, String currency, int dayOfIncome) {
		incomeDAO.add(new Income(name, amount, currency, dayOfIncome));
		return true;
	}
}

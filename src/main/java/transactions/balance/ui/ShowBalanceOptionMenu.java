package transactions.balance.ui;

import transactions.balance.service.BalanceCalculator;
import transactions.expense.dao.ExpenseDAOInMemory;
import transactions.expense.service.ExpenseService;
import transactions.income.dao.IncomeDAOInMemory;
import transactions.income.service.IncomeService;

public class ShowBalanceOptionMenu {
	private final IncomeService incomes = new IncomeService(new IncomeDAOInMemory());
	private final ExpenseService expenses = new ExpenseService(new ExpenseDAOInMemory());
	private BalanceController balanceController = new BalanceController(new BalanceCalculator(incomes, expenses));

	public void showMenu() {
		System.out.print(balanceController.getBalanceMenuText());
	}
}

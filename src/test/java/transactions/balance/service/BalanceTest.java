package transactions.balance.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.expense.dao.ExpenseDAOInMemory;
import transactions.expense.service.ExpenseService;
import transactions.income.dao.IncomeDAOInMemory;
import transactions.income.service.IncomeService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceTest {
	private IncomeService incomes;
	private ExpenseService expenses;
	private BalanceCalculator balance;

	@BeforeEach
	void setUp() {
		incomes = new IncomeService(new IncomeDAOInMemory());
		expenses = new ExpenseService(new ExpenseDAOInMemory());
		balance = new BalanceCalculator(incomes, expenses);
	}

	@Test
	void noIncomeAndNoExpenseGivesBalanceOfZero() {
		assertEquals(0, balance.calculate());
	}

	@Test
	void incomeAndNoExpenseGivesBalanceOfIncome() {
		incomes.add("salary", 10, "usd", 1);
		assertEquals(10, balance.calculate());
	}

	@Test
	void expenseAndNoIncomeGivesBalanceOfExpense() {
		expenses.add("electricity", 10, "usd", 1);
		assertEquals(-10, balance.calculate());
	}

	@Test
	void incomeAndExpenseGiveBalanceOfBoth() {
		incomes.add("salary", 100, "usd", 1);
		expenses.add("electricity", 10, "usd", 1);
		assertEquals(90, balance.calculate());
	}
}

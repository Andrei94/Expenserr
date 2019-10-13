package transactions.balance.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.balance.service.BalanceCalculator;
import transactions.expense.dao.ExpenseDAOInMemory;
import transactions.expense.service.ExpenseService;
import transactions.income.dao.IncomeDAOInMemory;
import transactions.income.service.IncomeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BalanceControllerTest {
	private BalanceController controller;

	@BeforeEach
	void setUp() {
		controller = new BalanceController(new BalanceCalculator(new IncomeService(new IncomeDAOInMemory()), new ExpenseService(new ExpenseDAOInMemory())));
	}

	@Test
	void createBalanceController() {
		assertNotNull(controller);
	}

	@Test
	void getBalanceControllerMenuText() {
		assertEquals("The current balance is: 0", controller.getBalanceMenuText());
	}
}

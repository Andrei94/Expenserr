package transactions.expense.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.expense.dao.ExpenseDAOInMemory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpenseServiceTest {
	private ExpenseService service;

	@BeforeEach
	void setUp() {
		service = new ExpenseService(new ExpenseDAOInMemory());
	}

	@Test
	void addingExpenseCreatesAnEntryInDAO() {
		assertTrue(service.add("electricity", 100, "usd", 1));
	}
}

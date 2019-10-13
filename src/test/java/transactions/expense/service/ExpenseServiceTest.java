package transactions.expense.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.expense.dao.ExpenseDAOInMemory;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

	@Test
	void addingExpenseWithAmount100IncreasesAmountBy100() {
		service.add("electricity", 100, "usd", 1);
		assertEquals(100, service.getTotalAmount());
	}
}

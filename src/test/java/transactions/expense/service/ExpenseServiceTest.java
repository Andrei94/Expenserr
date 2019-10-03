package transactions.expense.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.expense.dao.ExpenseDAOInMemory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpenseServiceTest {
	private ExpenseService controller;

	@BeforeEach
	void setUp() {
		controller = new ExpenseService(new ExpenseDAOInMemory());
	}

	@Test
	void addingDefaultIncomeCreatesAnEntryInDAO() {
		assertTrue(controller.add("electricity", 100, "usd", 1));
	}
}

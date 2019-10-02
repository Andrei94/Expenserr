package transactions.income.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.dao.IncomeDAOInMemory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IncomeServiceTest {
	private IncomeService controller;

	@BeforeEach
	void setUp() {
		controller = new IncomeService(new IncomeDAOInMemory());
	}

	@Test
	void addingDefaultIncomeCreatesAnEntryInDAO() {
		assertTrue(controller.add("salary", 100, "usd", 1));
	}
}

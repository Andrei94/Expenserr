package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

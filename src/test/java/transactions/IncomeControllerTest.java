package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IncomeControllerTest {
	private IncomeController controller;

	@BeforeEach
	void setUp() {
		controller = new IncomeController(new IncomeDAOInMemory());
	}

	@Test
	void addingDefaultIncomeCreatesAnEntryInDAO() {
		assertTrue(controller.add("salary", 100, "usd", 1));
	}
}

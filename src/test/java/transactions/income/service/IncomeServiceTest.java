package transactions.income.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.dao.IncomeDAOInMemory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IncomeServiceTest {
	private IncomeService service;

	@BeforeEach
	void setUp() {
		service = new IncomeService(new IncomeDAOInMemory());
	}

	@Test
	void addingIncomeCreatesAnEntryInDAO() {
		assertTrue(service.add("salary", 100, "usd", 1));
	}

	@Test
	void addingIncomeWithAmount100IncreasesAmountBy100() {
		service.add("salary", 100, "usd", 1);
		assertEquals(100, service.getTotalAmount());
	}
}

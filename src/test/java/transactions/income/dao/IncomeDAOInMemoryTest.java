package transactions.income.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.model.Income;
import transactions.income.service.IncomeDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeDAOInMemoryTest {
	private IncomeDAO dao;

	@BeforeEach
	void setUp() {
		dao = new IncomeDAOInMemory();
	}

	@Test
	void createdDAOIsEmpty() {
		assertEquals(0, dao.size());
	}

	@Test
	void addedDefaultIncomeToDAOIncreasesItsSize() {
		dao.add(new Income());
		assertEquals(1, dao.size());
	}

	@Test
	void addedIncomeToDAOIncreasesItsSize() {
		dao.add(new Income("salary", 10, "usd", 1));
		assertEquals(1, dao.size());
	}

	@Test
	void addingIncomeTwiceCreatesTwoIncomeEntries() {
		dao.add(new Income());
		dao.add(new Income());
		assertEquals(2, dao.size());
	}

	@Test
	void addingNullIncome() {
		dao.add(null);
		assertEquals(0, dao.size());
	}
}

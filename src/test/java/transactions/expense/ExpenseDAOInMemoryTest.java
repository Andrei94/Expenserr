package transactions.expense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseDAOInMemoryTest {
	private ExpenseDAO dao;

	@BeforeEach
	void setUp() {
		dao = new ExpenseDAOInMemory();
	}

	@Test
	void createdDAOIsEmpty() {
		assertEquals(0, dao.size());
	}

	@Test
	void addedDefaultExpenseToDAOIncreasesItsSize() {
		dao.add(new Expense());
		assertEquals(1, dao.size());
	}

	@Test
	void addedExpenseToDAOIncreasesItsSize() {
		dao.add(new Expense("electricity", 10, "usd", 1));
		assertEquals(1, dao.size());
	}

	@Test
	void addingExpenseTwiceCreatesTwoExpenseEntries() {
		dao.add(new Expense());
		dao.add(new Expense());
		assertEquals(2, dao.size());
	}

	@Test
	void addingNullExpense() {
		dao.add(null);
		assertEquals(0, dao.size());
	}
}
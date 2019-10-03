package transactions.expense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseTest {
	private Expense exp;

	@BeforeEach
	void setUp() {
		exp = new Expense();
	}

	@Test
	void expenseShouldHaveAmountZero() {
		assertEquals(0, exp.amount);
	}

	@Test
	void expenseShouldHaveNameEmptyString() {
		assertEquals("", exp.name);
	}

	@Test
	void expenseShouldHaveDollarDefaultCurrency() {
		assertEquals("usd", exp.currency);
	}

	@Test
	void expenseShouldHaveFirstDayOfMonthDefaultDay() {
		assertEquals(1, exp.dayOfExpense);
	}

	@Test
	void dayOfExpenseBelowOneShouldBeChangedToOne() {
		exp = new Expense("electricity", 100, "usd", -1);
		assertEquals(1, exp.dayOfExpense);
	}

	@Test
	void dayOfExpenseAboveThirtyOneShouldBeChangedToThirtyOne() {
		exp = new Expense("electricity", 100, "usd", 32);
		assertEquals(31, exp.dayOfExpense);
	}

	@Test
	void expenseShouldBeAbleToAcceptParameters() {
		exp = new Expense("electricity", 100, "usd", 15);
		assertEquals("electricity", exp.name);
		assertEquals(100, exp.amount);
		assertEquals("usd", exp.currency);
		assertEquals(15, exp.dayOfExpense);
	}
}

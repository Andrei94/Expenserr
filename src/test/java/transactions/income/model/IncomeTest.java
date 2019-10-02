package transactions.income.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeTest {
	private Income income;

	@BeforeEach
	void setUp() {
		income = new Income();
	}

	@Test
	void incomeShouldHaveAmountOfZero() {
		assertEquals(0, income.amount);
	}

	@Test
	void incomeShouldHaveNameEmptyString() {
		assertEquals("", income.name);
	}

	@Test
	void incomeShouldHaveDollarDefaultCurrency() {
		assertEquals("usd", income.currency);
	}

	@Test
	void incomeShouldHaveFirstDayOfMonthDefaultDay() {
		assertEquals(1, income.dayOfIncome);
	}

	@Test
	void dayOfIncomeBelowOneShouldBeChangedToOne() {
		income = new Income("salary", 100, "usd", -1);
		assertEquals(1, income.dayOfIncome);
	}

	@Test
	void dayOfIncomeAboveThirtyOneShouldBeChangedToThirtyOne() {
		income = new Income("salary", 100, "usd", 32);
		assertEquals(31, income.dayOfIncome);
	}

	@Test
	void incomeShouldBeAbleToAcceptParameters() {
		income = new Income("salary", 100, "usd", 15);
		assertEquals("salary", income.name);
		assertEquals(100, income.amount);
		assertEquals("usd", income.currency);
		assertEquals(15, income.dayOfIncome);
	}
}

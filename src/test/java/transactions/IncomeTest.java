package transactions;

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
	void incomeShouldBeAbleToAcceptParameters() {
		income = new Income("salary", 100, "usd");
		assertEquals("salary", income.name);
		assertEquals(100, income.amount);
		assertEquals("usd", income.currency);
	}
}

package transactions.income.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.exceptions.InvalidInputException;
import transactions.income.dao.IncomeDAOInMemory;
import transactions.income.service.IncomeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddIncomeControllerTest {
	private AddIncomeController mainMenuLogic;

	@BeforeEach
	void setUp() {
		mainMenuLogic = new AddIncomeController(new IncomeService(new IncomeDAOInMemory()));
	}

	@Test
	void getIncomeNameMenuText() {
		assertEquals("Enter income name: ", mainMenuLogic.getIncomeNameMenuText());
	}

	@Test
	void setIncomeName() {
		String incomeName = "salary";
		mainMenuLogic.setIncomeName(incomeName);
		assertEquals(incomeName, mainMenuLogic.incomeOption.name);
	}

	@Test
	void setIncomeAsEmptyStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setIncomeName(""));
	}

	@Test
	void getIncomeAmountMenuText() {
		assertEquals("Enter income amount: ", mainMenuLogic.getIncomeAmountMenuText());
	}

	@Test
	void setIncomeAmount() {
		String incomeAmount = "10";
		mainMenuLogic.setIncomeAmount(incomeAmount);
		assertEquals(10, mainMenuLogic.incomeOption.amount);
	}

	@Test
	void setIncomeAmountAsStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setIncomeAmount("abc"));
	}

	@Test
	void getIncomeCurrencyMenuText() {
		assertEquals("Enter income currency: ", mainMenuLogic.getIncomeCurrencyMenuText());
	}

	@Test
	void setIncomeCurrency() {
		String currency = "usd";
		mainMenuLogic.setIncomeCurrency(currency);
		assertEquals(currency, mainMenuLogic.incomeOption.currency);
	}

	@Test
	void setIncomeCurrencySomeStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setIncomeCurrency("test"));
	}

	@Test
	void getDayOfIncomeMenuText() {
		assertEquals("Enter day of income: ", mainMenuLogic.getDayOfIncomeMenuText());
	}

	@Test
	void setDayOfIncome() {
		String dayOfIncome = "10";
		mainMenuLogic.setDayOfIncome(dayOfIncome);
		assertEquals(10, mainMenuLogic.incomeOption.dayOfIncome);
	}

	@Test
	void setDayOfIncomeLessThanOneThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfIncome("0"));
	}

	@Test
	void setDayOfIncomeGreaterThanThirtyOneThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfIncome("32"));
	}

	@Test
	void setDayOfIncomeStringThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfIncome("abc"));
	}

	@Test
	void addIncome() {
		setIncome();
		assertEquals("Success!!!!", mainMenuLogic.addIncome());
	}

	@Test
	void addIncomeWithInvalidCurrency() {
		mainMenuLogic = new AddIncomeController(new IncomeService(new IncomeDAOInMemory()) {
			@Override
			public boolean add(String name, int amount, String currency, int dayOfIncome) {
				return false;
			}
		});
		setIncome();
		assertEquals("Failed to add income!!", mainMenuLogic.addIncome());
	}

	private void setIncome() {
		mainMenuLogic.setIncomeName("salary");
		mainMenuLogic.setIncomeAmount("10");
		mainMenuLogic.setIncomeCurrency("usd");
		mainMenuLogic.setDayOfIncome("20");
	}
}
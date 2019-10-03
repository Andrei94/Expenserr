package transactions.expense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.exceptions.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddExpenseControllerTest {
	private AddExpenseController mainMenuLogic;

	@BeforeEach
	void setUp() {
		mainMenuLogic = new AddExpenseController(new ExpenseService(new ExpenseDAOInMemory()));
	}

	@Test
	void getExpenseNameMenuText() {
		assertEquals("Enter expense name: ", mainMenuLogic.getExpenseNameMenuText());
	}

	@Test
	void setExpenseName() {
		String expenseName = "electricity";
		mainMenuLogic.setExpenseName(expenseName);
		assertEquals(expenseName, mainMenuLogic.expenseDTO.name);
	}

	@Test
	void setExpenseAsEmptyStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setExpenseName(""));
	}

	@Test
	void getExpenseAmountMenuText() {
		assertEquals("Enter expense amount: ", mainMenuLogic.getExpenseAmountMenuText());
	}

	@Test
	void setExpenseAmount() {
		String expenseAmount = "10";
		mainMenuLogic.setExpenseAmount(expenseAmount);
		assertEquals(10, mainMenuLogic.expenseDTO.amount);
	}

	@Test
	void setExpenseAmountAsStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setExpenseAmount("abc"));
	}

	@Test
	void getExpenseCurrencyMenuText() {
		assertEquals("Enter expense currency: ", mainMenuLogic.getExpenseCurrencyMenuText());
	}

	@Test
	void setExpenseCurrency() {
		String currency = "usd";
		mainMenuLogic.setExpenseCurrency(currency);
		assertEquals(currency, mainMenuLogic.expenseDTO.currency);
	}

	@Test
	void setExpenseCurrencySomeStringThrowsInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setExpenseCurrency("test"));
	}

	@Test
	void getDayOfExpenseMenuText() {
		assertEquals("Enter day of expense: ", mainMenuLogic.getDayOfExpenseMenuText());
	}

	@Test
	void setDayOfExpense() {
		String dayOfExpense = "10";
		mainMenuLogic.setDayOfExpense(dayOfExpense);
		assertEquals(10, mainMenuLogic.expenseDTO.dayOfExpense);
	}

	@Test
	void setDayOfExpenseLessThanOneThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfExpense("0"));
	}

	@Test
	void setDayOfExpenseGreaterThanThirtyOneThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfExpense("32"));
	}

	@Test
	void setDayOfExpenseStringThrowsInvalidOptionException() {
		assertThrows(InvalidInputException.class, () -> mainMenuLogic.setDayOfExpense("abc"));
	}

	@Test
	void addExpense() {
		setExpense();
		assertEquals("Success!!!!", mainMenuLogic.addExpense());
	}

	@Test
	void addExpenseWithInvalidCurrency() {
		mainMenuLogic = new AddExpenseController(new ExpenseService(new ExpenseDAOInMemory()) {
			@Override
			public boolean add(String name, int amount, String currency, int dayOfExpense) {
				return false;
			}
		});
		setExpense();
		assertEquals("Failed to add expense!!", mainMenuLogic.addExpense());
	}

	private void setExpense() {
		mainMenuLogic.setExpenseName("electricity");
		mainMenuLogic.setExpenseAmount("10");
		mainMenuLogic.setExpenseCurrency("usd");
		mainMenuLogic.setDayOfExpense("20");
	}
}
package mainMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exceptions.InvalidInputException;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {
	private MainMenuController mainMenu;

	@BeforeEach
	void setUp() {
		mainMenu = new MainMenuController(new MainMenu());
	}

	@Test
	void getMenuShouldReturnMainMenu() {
		assertEquals("1. Add income" + System.lineSeparator() +
				"2. Add expense" + System.lineSeparator() +
				"3. Show balance" + System.lineSeparator() +
				"Enter option: ", mainMenu.getMainMenu());
	}

	@Test
	void selectingAddIncomeShowsAddIncomeMenu() {
		final boolean[] addIncomeCalled = {false};
		mainMenu = new MainMenuController(new MainMenu() {
			@Override
			public void showAddIncome() {
				addIncomeCalled[0] = true;
			}

			@Override
			public void showAddExpense() {
			}
		});
		mainMenu.handleMainMenuOption("1");
		assertTrue(addIncomeCalled[0]);
	}

	@Test
	void selectingAddExpenseShowsAddExpenseMenu() {
		final boolean[] addExpenseCalled = {false};
		mainMenu = new MainMenuController(new MainMenu() {
			@Override
			public void showAddIncome() {
			}

			@Override
			public void showAddExpense() {
				addExpenseCalled[0] = true;
			}
		});
		mainMenu.handleMainMenuOption("2");
		assertTrue(addExpenseCalled[0]);
	}

	@Test
	void selectingShowBalanceShowsTheBalance() {
		final boolean[] showBalanceCalled = {false};
		mainMenu = new MainMenuController(new MainMenu() {
			@Override
			public void showAddIncome() {
			}

			@Override
			public void showAddExpense() {
			}

			@Override
			public void showBalance() {
				showBalanceCalled[0] = true;
			}
		});
		mainMenu.handleMainMenuOption("3");
		assertTrue(showBalanceCalled[0]);
	}

	@Test
	void handlingTextOptionThrowsException() {
		assertThrows(InvalidInputException.class, () -> mainMenu.handleMainMenuOption("abc"));
	}

	@Test
	void handlingInvalidOptionThrowsException() {
		assertThrows(InvalidInputException.class, () -> mainMenu.handleMainMenuOption("0"));
	}
}

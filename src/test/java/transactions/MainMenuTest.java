package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transactions.income.exceptions.InvalidInputException;

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
		});
		mainMenu.handleMainMenuOption("1");
		assertTrue(addIncomeCalled[0]);
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

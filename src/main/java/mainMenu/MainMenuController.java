package mainMenu;

import exceptions.InvalidInputException;

public class MainMenuController {
	private MainMenu mainMenu;

	public MainMenuController(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getMainMenu() {
		return "1. Add income" + System.lineSeparator() +
				"2. Add expense" + System.lineSeparator() +
				"3. Show balance" + System.lineSeparator() +
				"Enter option: ";
	}

	public void handleMainMenuOption(String inputOption) {
		int option;
		try {
			option = Integer.parseUnsignedInt(inputOption);
			if(option == 1)
				mainMenu.showAddIncome();
			else if(option == 2)
				mainMenu.showAddExpense();
			else if(option == 3)
				mainMenu.showBalance();
			else
				throwInvalidOptionException(inputOption);
		} catch(NumberFormatException ex) {
			throwInvalidOptionException(inputOption);
		}
	}

	private void throwInvalidOptionException(String inputOption) {
		throw new InvalidInputException("Invalid option: " + inputOption);
	}
}

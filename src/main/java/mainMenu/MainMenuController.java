package mainMenu;

import transactions.income.exceptions.InvalidInputException;

public class MainMenuController {
	private MainMenu mainMenu;

	public MainMenuController(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getMainMenu() {
		return "1. Add income" + System.lineSeparator() + "Enter option: ";
	}

	public void handleMainMenuOption(String inputOption) {
		int option;
		try {
			option = Integer.parseUnsignedInt(inputOption);
			if(option == 1)
				mainMenu.showAddIncome();
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

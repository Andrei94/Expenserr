package transactions;

import transactions.income.exceptions.InvalidInputException;
import transactions.income.ui.AddIncomeOptionMenu;

import java.io.*;

public class MainMenu {
	private MainMenuController mainMenuController = new MainMenuController(this);

	public void showMainMenu() {
		System.out.print(mainMenuController.getMainMenu());
	}

	public void readOption() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			mainMenuController.handleMainMenuOption(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showAddIncome() {
		AddIncomeOptionMenu addIncomeOptionMenu = new AddIncomeOptionMenu();
		addIncomeOptionMenu.showMenu();
	}
}

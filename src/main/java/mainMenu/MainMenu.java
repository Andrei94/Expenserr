package mainMenu;

import exceptions.InvalidInputException;
import transactions.balance.ui.ShowBalanceOptionMenu;
import transactions.expense.ui.AddExpenseOptionMenu;
import transactions.income.ui.AddIncomeOptionMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public void showAddExpense() {
		AddExpenseOptionMenu addExpenseOptionMenu = new AddExpenseOptionMenu();
		addExpenseOptionMenu.showMenu();
	}

	public void showBalance() {
		ShowBalanceOptionMenu showBalanceOptionMenu = new ShowBalanceOptionMenu();
		showBalanceOptionMenu.showMenu();
	}
}

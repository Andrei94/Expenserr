package transactions.income.ui;

import transactions.income.dao.IncomeDAOInMemory;
import transactions.income.service.IncomeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddIncomeOptionMenu {
	private AddIncomeController addIncomeController = new AddIncomeController(new IncomeService(new IncomeDAOInMemory()));

	public void showMenu() {
		System.out.print(addIncomeController.getIncomeNameMenuText());
		handleIncomeNameInput();
		System.out.print(addIncomeController.getIncomeAmountMenuText());
		handleIncomeAmountInput();
		System.out.print(addIncomeController.getIncomeCurrencyMenuText());
		handleIncomeCurrencyInput();
		System.out.print(addIncomeController.getDayOfIncomeMenuText());
		handleDayOfIncomeInput();
		System.out.println(addIncomeController.addIncome());
	}

	private void handleIncomeNameInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addIncomeController.setIncomeName(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleIncomeAmountInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addIncomeController.setIncomeAmount(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleIncomeCurrencyInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addIncomeController.setIncomeCurrency(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleDayOfIncomeInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addIncomeController.setDayOfIncome(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

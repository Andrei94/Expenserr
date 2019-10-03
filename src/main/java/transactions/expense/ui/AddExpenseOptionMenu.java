package transactions.expense.ui;

import transactions.expense.dao.ExpenseDAOInMemory;
import transactions.expense.service.ExpenseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddExpenseOptionMenu {
	private AddExpenseController addExpenseController = new AddExpenseController(new ExpenseService(new ExpenseDAOInMemory()));

	public void showMenu() {
		System.out.print(addExpenseController.getExpenseNameMenuText());
		handleExpenseNameInput();
		System.out.print(addExpenseController.getExpenseAmountMenuText());
		handleExpenseAmountInput();
		System.out.print(addExpenseController.getExpenseCurrencyMenuText());
		handleExpenseCurrencyInput();
		System.out.print(addExpenseController.getDayOfExpenseMenuText());
		handleDayOfExpenseInput();
		System.out.println(addExpenseController.addExpense());
	}

	private void handleExpenseNameInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addExpenseController.setExpenseName(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleExpenseAmountInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addExpenseController.setExpenseAmount(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleExpenseCurrencyInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addExpenseController.setExpenseCurrency(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void handleDayOfExpenseInput() {
		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in));
		try {
			addExpenseController.setDayOfExpense(bufferedInputStream.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

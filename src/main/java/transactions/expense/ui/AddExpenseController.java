package transactions.expense.ui;

import transactions.expense.service.ExpenseService;
import exceptions.InvalidInputException;

public class AddExpenseController {
	public AddExpenseDTO expenseDTO = new AddExpenseDTO();
	private final ExpenseService service;

	public AddExpenseController(ExpenseService service) {
		this.service = service;
	}

	public String getExpenseNameMenuText() {
		return "Enter expense name: ";
	}

	public void setExpenseName(String name) {
		if(name.isEmpty())
			throw new InvalidInputException("Expense name cannot be empty");
		this.expenseDTO.name = name;
	}

	public String getExpenseAmountMenuText() {
		return "Enter expense amount: ";
	}

	public void setExpenseAmount(String amount) {
		try {
			this.expenseDTO.amount = Integer.parseUnsignedInt(amount);
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + amount + "\"");
		}
	}

	public String getExpenseCurrencyMenuText() {
		return "Enter expense currency: ";
	}

	public void setExpenseCurrency(String currency) {
		if(currency.equals("usd"))
			this.expenseDTO.currency = currency;
		else
			throw new InvalidInputException("Unknown currency: \"" + currency + "\"");
	}

	public String getDayOfExpenseMenuText() {
		return "Enter day of expense: ";
	}

	public void setDayOfExpense(String dayOfExpense) {
		try {
			int day = Integer.parseUnsignedInt(dayOfExpense);
			if(day < 1 || day > 31)
				throw new InvalidInputException("Day of expense must be between 1 and 31");
			this.expenseDTO.dayOfExpense = day;
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + dayOfExpense + "\"");
		}
	}

	public String addExpense() {
		if(service.add(expenseDTO.name, expenseDTO.amount, expenseDTO.currency, expenseDTO.dayOfExpense))
			return "Success!!!!";
		else
			return "Failed to add expense!!";
	}
}

package transactions.income.ui;

import transactions.income.exceptions.InvalidInputException;
import transactions.income.service.IncomeService;

public class AddIncomeController {
	public AddIncomeDTO incomeOption = new AddIncomeDTO();
	private final IncomeService controller;

	public AddIncomeController(IncomeService controller) {
		this.controller = controller;
	}

	public String getIncomeNameMenuText() {
		return "Enter income name: ";
	}

	public void setIncomeName(String name) {
		if(name.isEmpty())
			throw new InvalidInputException("Income name cannot be empty");
		this.incomeOption.name = name;
	}

	public String getIncomeAmountMenuText() {
		return "Enter income amount: ";
	}

	public void setIncomeAmount(String incomeAmount) {
		try {
			this.incomeOption.amount = Integer.parseUnsignedInt(incomeAmount);
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + incomeAmount + "\"");
		}
	}

	public String getIncomeCurrencyMenuText() {
		return "Enter income currency: ";
	}

	public void setIncomeCurrency(String currency) {
		if(currency.equals("usd"))
			this.incomeOption.currency = currency;
		else
			throw new InvalidInputException("Unknown currency: \"" + currency + "\"");
	}

	public String getDayOfIncomeMenuText() {
		return "Enter day of income: ";
	}

	public void setDayOfIncome(String dayOfIncome) {
		try {
			int day = Integer.parseUnsignedInt(dayOfIncome);
			if(day < 1 || day > 31)
				throw new InvalidInputException("Day of income must be between 1 and 31");
			this.incomeOption.dayOfIncome = day;
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + dayOfIncome + "\"");
		}
	}

	public String addIncome() {
		if(controller.add(incomeOption.name, incomeOption.amount, incomeOption.currency, incomeOption.dayOfIncome))
			return "Success!!!!";
		else
			return "Failed to add income!!";
	}
}

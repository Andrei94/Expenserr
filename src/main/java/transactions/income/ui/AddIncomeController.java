package transactions.income.ui;

import exceptions.InvalidInputException;
import transactions.income.service.IncomeService;

public class AddIncomeController {
	public AddIncomeDTO incomeDTO = new AddIncomeDTO();
	private final IncomeService service;

	public AddIncomeController(IncomeService service) {
		this.service = service;
	}

	public String getIncomeNameMenuText() {
		return "Enter income name: ";
	}

	public void setIncomeName(String name) {
		if(name.isEmpty())
			throw new InvalidInputException("Income name cannot be empty");
		this.incomeDTO.name = name;
	}

	public String getIncomeAmountMenuText() {
		return "Enter income amount: ";
	}

	public void setIncomeAmount(String incomeAmount) {
		try {
			this.incomeDTO.amount = Integer.parseUnsignedInt(incomeAmount);
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + incomeAmount + "\"");
		}
	}

	public String getIncomeCurrencyMenuText() {
		return "Enter income currency: ";
	}

	public void setIncomeCurrency(String currency) {
		if(currency.equals("usd"))
			this.incomeDTO.currency = currency;
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
			this.incomeDTO.dayOfIncome = day;
		} catch(NumberFormatException ex) {
			throw new InvalidInputException("Invalid number: \"" + dayOfIncome + "\"");
		}
	}

	public String addIncome() {
		if(service.add(incomeDTO.name, incomeDTO.amount, incomeDTO.currency, incomeDTO.dayOfIncome))
			return "Success!!!!";
		else
			return "Failed to add income!!";
	}
}

package transactions.balance.ui;

import transactions.balance.service.BalanceCalculator;

public class BalanceController {
	private final BalanceCalculator calculator;

	public BalanceController(BalanceCalculator calculator) {
		this.calculator = calculator;
	}

	public String getBalanceMenuText() {
		return "The current balance is: " + calculator.calculate();
	}
}

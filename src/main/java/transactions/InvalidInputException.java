package transactions;

public class InvalidInputException extends RuntimeException {
	InvalidInputException(String option) {
		super(option);
	}
}

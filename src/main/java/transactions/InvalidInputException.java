package transactions;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String option) {
		super(option);
	}
}

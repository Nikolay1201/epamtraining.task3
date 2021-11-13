package by.epam.training.arithmexpcalc;

public class IncorrectExpressionException extends RuntimeException {
	public IncorrectExpressionException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	public IncorrectExpressionException(String errorMessage) {
		super(errorMessage);
	}
}

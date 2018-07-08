package info.office.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
	}

	public IdNotFoundException(String message) {
		super(message);
	}

	public IdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

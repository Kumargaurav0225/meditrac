package proj.meditrac.core.exceptions;

public class SchemaException extends Exception {

	private static final long serialVersionUID = -5666391273702554265L;

	public SchemaException() {
	}

	public SchemaException(String message) {
		super(message);
	}

	public SchemaException(Throwable cause) {
		super(cause);
	}

	public SchemaException(String message, Throwable cause) {
		super(message, cause);
	}

	public SchemaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

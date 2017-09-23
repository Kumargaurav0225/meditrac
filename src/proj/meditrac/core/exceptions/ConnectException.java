package proj.meditrac.core.exceptions;

public class ConnectException extends Exception {

	private static final long serialVersionUID = -749423542378180765L;

	public ConnectException() {
	}

	public ConnectException(String message) {
		super(message);
	}

	public ConnectException(Throwable cause) {
		super(cause);
	}

	public ConnectException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

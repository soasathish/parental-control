package exceptions;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5393788176772081120L;

	public BaseException() {
		super();
		
	}


	public BaseException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BaseException(final String message) {
		super(message);
		
	}

	public BaseException(final Throwable cause) {
		super(cause);
		
	}

	
}

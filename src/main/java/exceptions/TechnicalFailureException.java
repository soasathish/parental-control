package exceptions;

public class TechnicalFailureException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6983983380996733824L;

	public TechnicalFailureException(String message, Throwable cause) {
        super(message, cause);
    }

	public TechnicalFailureException() {
		super();
		
	}

	public TechnicalFailureException(String message) {
		super(message);
		
	}

	public TechnicalFailureException(Throwable cause) {
		super(cause);
		
	}
	
}

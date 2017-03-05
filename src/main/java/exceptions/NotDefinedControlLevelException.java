package exceptions;

public class NotDefinedControlLevelException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3796728075678539189L;

	public NotDefinedControlLevelException(String message, Throwable cause) {
        super(message, cause);
    }

	public NotDefinedControlLevelException() {
		super();
		
	}

	public NotDefinedControlLevelException(String message) {
		super(message);
		
	}

	public NotDefinedControlLevelException(Throwable cause) {
		super(cause);
		
	}
	
}

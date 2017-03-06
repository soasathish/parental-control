package exceptions;

/**
 * @author sathishkumarnatarajan
 *
 */
public class TitleNotFoundException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4220850878055752601L;

	public TitleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

	public TitleNotFoundException() {
		super();
		
	}

	public TitleNotFoundException(String message) {
		super(message);
		
	}

	public TitleNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
}

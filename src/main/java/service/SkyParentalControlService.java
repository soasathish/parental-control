package service;

import exceptions.NotDefinedControlLevelException;
import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

/**
 * @author sathishkumarnatarajan
 * This is the main service which will be called by the User /client to check the parental control access by passing the  movie Id and parental control access level of user
 * The service calculates the decision whether the current user has access level according to the business rules set in the service layer.
 * The actual business logic is that As a customer I don’t want my account to be able to access movies that have a higher parental control level than my current preference setting.
 *
 */
public class SkyParentalControlService implements ParentalControlService {
	private final ReferenceDataMovieService movieService;

	public SkyParentalControlService(ReferenceDataMovieService movieService) {
		this.movieService = movieService;
	}

	/*
	 * In Real time the atParentalControlLevel and moviedId will be retrieved by
	 * Using the request parameter in case of Controller Or using commandline
	 * and get the parameter from the User
	 * 
	 * The service  accept as input the customer’s parental control level
	 * preference and a movie id. If the customer is able to watch the movie the
	 * ParentalControlService  indicate this to the calling client
	 * (non-Javadoc)
	 * 
	 * @see service.ParentalControlService#isAllowedToWatch(java.lang.String,
	 * java.lang.String)
	 */
	public Boolean isAllowedToWatch(String moviedId, String atParentalControlLevel)
			throws NotDefinedControlLevelException, TitleNotFoundException, TechnicalFailureException {
		try {
			ParentalControlLevelEnum customerPcl = getParentalControlLevelByMovieIdAndParentalControl(
					atParentalControlLevel, moviedId);

			ParentalControlLevelEnum moviePlc = getParentalControlLevelByMovieId(moviedId);
			return moviePlc.getValue() <= customerPcl.getValue();
		} catch (TitleNotFoundException e) {
			throw new TitleNotFoundException("The movie service could not find the movie with the id: " + moviedId, e);
		} catch (TechnicalFailureException e) {
			throw new TechnicalFailureException("System error, movie cannot be watched.", e);
		}
	}

	/**
	 * This method checks the parental Control level by calling the third party service -movie service
	 * 
	 * @param movieId
	 * @return
	 * @throws NotDefinedControlLevelException
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	private ParentalControlLevelEnum getParentalControlLevelByMovieId(String movieId)
			throws NotDefinedControlLevelException, TitleNotFoundException, TechnicalFailureException {
		String controlLevel = movieService.getParentalControlLevel(movieId);
		return getParentalControlLevelByMovieIdAndParentalControl(controlLevel, MovieService.class.getSimpleName());

	}

	/**
	 * The method  accept as input the customer’s parental control level preference and a movie id. 
	 * it returns the parental access level 
	 * @param controlLevel
	 * @param source
	 * @return
	 * @throws NotDefinedControlLevelException
	 */
	private ParentalControlLevelEnum getParentalControlLevelByMovieIdAndParentalControl(String controlLevel,
			String source) throws NotDefinedControlLevelException {
		try {
			return ParentalControlLevelEnum.toEnum(controlLevel);
		} catch (NotDefinedControlLevelException e) {
			throw new NotDefinedControlLevelException("Not defined control level: " + controlLevel + " in " + source,
					e);
		}
	}

}
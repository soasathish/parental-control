package service;



import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

/**
 * @author sathishkumarnatarajan
 *
 */
public class ReferenceDataMovieService implements MovieService {


	
	/*
	 * This service in real time will be accessing database or some other real time time  data and gets the Access control for the movie ID passed 
	 *  getParentalControlLevel call that accepts the movie id as an input and returns the parental control level for that movie as a string
	 *  (non-Javadoc)
	 * @see service.MovieService#getParentalControlLevel(java.lang.String)
	 */
	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		String parentalControl=RefernceDataMovieEnum.getParentalLevels(movieId);
		return parentalControl;

	}

}

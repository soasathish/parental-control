package service;



import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

public class ReferenceDataMovieService implements MovieService {


	
	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		String parentalControl=RefernceDataMovieEnum.getParentalLevels(movieId);
		return parentalControl;

	}

}

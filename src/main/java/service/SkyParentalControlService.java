package service;

import exceptions.NotDefinedControlLevelException;
import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

public class SkyParentalControlService implements ParentalControlService {
    private final ReferenceDataMovieService movieService;

    public SkyParentalControlService(ReferenceDataMovieService movieService) {
        this.movieService = movieService;
    }

    
    /* In Real time the atParentalControlLevel and moviedId will be retrieved by Using the request parameter in case of Controller
     * Or using commandline and get the parameter from the User 
     * (non-Javadoc)
     * @see service.ParentalControlService#isAllowedToWatch(java.lang.String, java.lang.String)
     */
    public Boolean isAllowedToWatch(String moviedId, String atParentalControlLevel) throws NotDefinedControlLevelException, TitleNotFoundException, TechnicalFailureException {
        try {
        	ParentalControlLevelEnum customerPcl = getParentalControlLevelByMovieIdAndParentalControl(atParentalControlLevel,moviedId);
        	
        	ParentalControlLevelEnum moviePlc = getParentalControlLevelByMovieId(moviedId);
            return moviePlc.getValue() <= customerPcl.getValue();
        } catch (TitleNotFoundException e) {
            throw new TitleNotFoundException("The movie service could not find the movie with the id: " + moviedId, e);
        } catch (TechnicalFailureException e) {
            throw new TechnicalFailureException("System error, movie cannot be watched.", e);
        }
    }

    private ParentalControlLevelEnum getParentalControlLevelByMovieId(String movieId) throws NotDefinedControlLevelException, TitleNotFoundException, TechnicalFailureException {
        String controlLevel = movieService.getParentalControlLevel(movieId);
        return getParentalControlLevelByMovieIdAndParentalControl(controlLevel, MovieService.class.getSimpleName());

    }

    private ParentalControlLevelEnum getParentalControlLevelByMovieIdAndParentalControl(String controlLevel, String source) throws NotDefinedControlLevelException {
        try {
            return ParentalControlLevelEnum.toEnum(controlLevel);
        } catch (NotDefinedControlLevelException e) {
            throw new NotDefinedControlLevelException("Not defined control level: " + controlLevel + " in " + source, e);
        }
    }

}
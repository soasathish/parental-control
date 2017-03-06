package service;

import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

public interface MovieService {
	
	
    /** Method to pass movie id and returns the parental control level as the return type.
     * If the movie id is not present in the list  -TitleNotFoundException is thrown
     * @param movieId
     * @return
     * @throws TitleNotFoundException
     * @throws TechnicalFailureException
     */
    String getParentalControlLevel(String movieId)
            throws TitleNotFoundException,
            TechnicalFailureException;
}

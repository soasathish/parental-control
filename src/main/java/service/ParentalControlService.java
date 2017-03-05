package service;

import exceptions.NotDefinedControlLevelException;
import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

public interface ParentalControlService {

    /**
     * @param moviedId id for the movie to watch
     * @param atParentalControlLevel prefered parental
     */
    Boolean isAllowedToWatch(String moviedId, String atParentalControlLevel)
            throws NotDefinedControlLevelException,
            TitleNotFoundException,
            TechnicalFailureException;
}

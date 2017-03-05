package service;

import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;

public interface MovieService {
    String getParentalControlLevel(String movieId)
            throws TitleNotFoundException,
            TechnicalFailureException;
}

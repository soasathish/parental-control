package com.sky.parental_control;



import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.Test;

import exceptions.NotDefinedControlLevelException;
import exceptions.TechnicalFailureException;
import exceptions.TitleNotFoundException;
import junit.framework.Assert;
import service.ParentalControlService;
import service.ReferenceDataMovieService;
import service.SkyParentalControlService;

public class ParentalControlServiceTest {
	ReferenceDataMovieService movieService = mock(ReferenceDataMovieService.class);
    ParentalControlService parentalControlService = new SkyParentalControlService(movieService);

    @Test
    public void isAllowedToWatchTest() throws TechnicalFailureException, TitleNotFoundException, NotDefinedControlLevelException {
        when(movieService.getParentalControlLevel("movieU")).thenReturn("U");
        Assert.assertTrue("Movie parental control level PG should be allowed for client parental control PG", parentalControlService.isAllowedToWatch("movieU", "PG"));
        when(movieService.getParentalControlLevel("moviePG")).thenReturn("PG");
        Assert.assertTrue("Movie parental control level PG should be allowed for client parental control PG", parentalControlService.isAllowedToWatch("moviePG", "PG"));
        when(movieService.getParentalControlLevel("movie12")).thenReturn("12");
        Assert.assertFalse("Movie parental control level 12 should not be allowed for client parental control PG", parentalControlService.isAllowedToWatch("movie12", "PG"));
    }

    @Test(expected = NotDefinedControlLevelException.class)
    public void isAllowedToWatchNotDefinedControlLevelClientException() throws TitleNotFoundException, NotDefinedControlLevelException, TechnicalFailureException {
        parentalControlService.isAllowedToWatch("someMovieId","NotDefinedParentalControl");
    }

    @Test(expected = NotDefinedControlLevelException.class)
    public void isAllowedToWatchNotDefinedControlLevelMovieServiceException() throws TechnicalFailureException, TitleNotFoundException, NotDefinedControlLevelException {
        when(movieService.getParentalControlLevel(anyString())).thenReturn("NotDefinedParentalControl");
        parentalControlService.isAllowedToWatch("someMovieId", "U");
    }

    @Test(expected = TitleNotFoundException.class)
    public void isAllowedToWatchTitleNotFoundException() throws TitleNotFoundException, NotDefinedControlLevelException, TechnicalFailureException {
        when(movieService.getParentalControlLevel(anyString())).thenThrow(TitleNotFoundException.class);
        parentalControlService.isAllowedToWatch("someMovieId", "U");
    }

    @Test(expected = TechnicalFailureException.class)
    public void isAllowedToWatchTechnicalFailureException() throws TitleNotFoundException, NotDefinedControlLevelException, TechnicalFailureException {
        when(movieService.getParentalControlLevel(anyString())).thenThrow(TechnicalFailureException.class);
        parentalControlService.isAllowedToWatch("someMovieId", "U");
    }

}


package com.sky.parental_control;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.NotDefinedControlLevelException;
import service.ParentalControlLevelEnum;

public class ParentalControlLevelTest {

    @Test
    public void getValueTest() {
        Assert.assertEquals("Wrong id for: " + ParentalControlLevelEnum.ACCESS_U, ParentalControlLevelEnum.ACCESS_U.getValue(), 0);
        Assert.assertEquals("Wrong id for: " + ParentalControlLevelEnum.ACCESS_PG, ParentalControlLevelEnum.ACCESS_PG.getValue(), 1);
        Assert.assertEquals("Wrong id for: " + ParentalControlLevelEnum.ACCESS_12, ParentalControlLevelEnum.ACCESS_12.getValue(), 2);
        Assert.assertEquals("Wrong id for: " + ParentalControlLevelEnum.ACCESS_15, ParentalControlLevelEnum.ACCESS_15.getValue(), 3);
        Assert.assertEquals("Wrong id for: " + ParentalControlLevelEnum.ACCESS_18, ParentalControlLevelEnum.ACCESS_18.getValue(), 4);
        Assert.assertNotEquals("For: " + ParentalControlLevelEnum.ACCESS_U + "id should be 0", ParentalControlLevelEnum.ACCESS_U.getValue(), 1);
    }

    @Test
    public void toEnumTest() throws NotDefinedControlLevelException {
        Assert.assertSame("U should be a valid ParentalControlLevelEnum and should be mapped to " + ParentalControlLevelEnum.ACCESS_U, ParentalControlLevelEnum.ACCESS_U, ParentalControlLevelEnum.toEnum("U"));
        Assert.assertSame("PG should be a valid ParentalControlLevelEnum and should be mapped to " + ParentalControlLevelEnum.ACCESS_PG, ParentalControlLevelEnum.ACCESS_PG, ParentalControlLevelEnum.toEnum("PG"));
        Assert.assertSame("12 should be a valid ParentalControlLevelEnum and should be mapped to " + ParentalControlLevelEnum.ACCESS_12, ParentalControlLevelEnum.ACCESS_12, ParentalControlLevelEnum.toEnum("12"));
        Assert.assertSame("15 should be a valid ParentalControlLevelEnum and should be mapped to " + ParentalControlLevelEnum.ACCESS_15, ParentalControlLevelEnum.ACCESS_15, ParentalControlLevelEnum.toEnum("15"));
        Assert.assertSame("18 should be a valid ParentalControlLevelEnum and should be mapped to " + ParentalControlLevelEnum.ACCESS_18, ParentalControlLevelEnum.ACCESS_18, ParentalControlLevelEnum.toEnum("18"));
        Assert.assertNotSame("U should not be mapped to " + ParentalControlLevelEnum.ACCESS_PG, ParentalControlLevelEnum.ACCESS_PG, ParentalControlLevelEnum.toEnum("U"));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = NotDefinedControlLevelException.class)
    public void toEnumExceptionTest() throws NotDefinedControlLevelException {
        ParentalControlLevelEnum.toEnum("Non existing control level");
    }

}

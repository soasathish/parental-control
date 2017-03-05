package service;

import java.util.Arrays;

import exceptions.NotDefinedControlLevelException;

public enum ParentalControlLevelEnum {
    ACCESS_U(0),
    ACCESS_PG(1),
    ACCESS_12(2),
    ACCESS_15(3),
    ACCESS_18(4);

    private final int value;
    private static final String prefix = "ACCESS_";

    ParentalControlLevelEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    public static ParentalControlLevelEnum toEnum(String str) throws NotDefinedControlLevelException {
        try {
            return ParentalControlLevelEnum.valueOf(prefix + str);
        } catch (IllegalArgumentException e) {
            throw new NotDefinedControlLevelException("Parental level: " + str + " not defined, it should be on of: " + getParentalLevels(), e);
        }
    }

    private static String getParentalLevels() {
        return Arrays.stream(ParentalControlLevelEnum.values()).map(
        		ParentalControlLevelEnum::removePrefix).reduce((a, b) -> a + ", " + b).get();
    }

    private static String removePrefix(ParentalControlLevelEnum access) {
        return access.toString().replaceFirst(prefix, "");
    }
}

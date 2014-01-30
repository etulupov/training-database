package com.noveo.tulupov.trainings.booklibrary.util.validator;

public class ValidatorFactory {
    public static Validator getDateValidator() {
        return new YearValidator();
    }
    public static Validator getIsbnValidator() {
        return new IsbnValidator();
    }
}

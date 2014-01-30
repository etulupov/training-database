package com.noveo.tulupov.trainings.booklibrary.util.validator;

public class YearValidator implements Validator {
    private static final int MIN_YEAR = 500;
    private static final int MAX_YEAR = 2014;

    YearValidator() {

    }


    @Override
    public void validate(String data) throws ValidateException {
        try {
            int year = Integer.parseInt(data);
            if (year < MIN_YEAR) {
                throw new ValidateException("Year can't be less than " + MIN_YEAR);
            }
            if (year > MAX_YEAR) {
                throw new ValidateException("Year can't be more than " + MAX_YEAR);
            }
        } catch (NumberFormatException e) {
            throw new ValidateException("Year isn't a number");
        }
    }
}

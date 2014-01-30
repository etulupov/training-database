package com.noveo.tulupov.trainings.booklibrary.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsbnValidator implements Validator {
    private static final int MIN_YEAR = 500;
    private static final int MAX_YEAR = 2014;

    IsbnValidator() {

    }


    @Override
    public void validate(String data) throws ValidateException {
        Pattern pattern = Pattern.compile("^[0-9]{10,13}");
        Matcher matcher = pattern.matcher(data);
        if (!matcher.find()) {
            throw new ValidateException("Your input isn't a ISBN code");
        }
    }
}

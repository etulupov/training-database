package com.noveo.tulupov.trainings.booklibrary.util;

import java.util.List;

public class StringUtils {
    public static final String join(List<String> list, final String delimiter) {
        StringBuffer sb = new StringBuffer();
        String delim = "";
        for (String i : list) {
            sb.append(delim).append(i);
            delim = delimiter;
        }
        return sb.toString();
    }
}

package com.rf.recipefinder.util;

public class StringFormatter {

    public static String trimAndCapitalizeFirstLetter(String str) {
        str = str.trim().toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String trimAndLowercase(String str) {
        return str.trim().toLowerCase();
    }

}

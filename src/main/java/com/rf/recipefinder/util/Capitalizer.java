package com.rf.recipefinder.util;

public class Capitalizer {

    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}

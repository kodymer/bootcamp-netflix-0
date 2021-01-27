package com.everis.d4i.tutorial;

public class Check {

    public static <T> T notNull(T value, String parameterName) {
        
        if(value == null) {
            throw new  IllegalArgumentException(parameterName);
        }

        return value;
    }

    public static <T> T notValid(T value, String parameterName) {
        
        notNull(value, parameterName);

        var isNumber = Number.class.isAssignableFrom(value.getClass());
        if( isNumber && ((Number)value).doubleValue() <= 0) {
            throw new  IllegalArgumentException(parameterName);
        }

        return value;
    }

    public static String notNullOrEmpty(String value, String parameterName) {
        
        if(value == null || value.isEmpty()) {
            throw new  IllegalArgumentException(parameterName);
        }

        return value;
    }

    public static <T> T[] notNullOrEmpty(T[] value, String parameterName) {
        
        if (value == null || value.length <= 0) {
            throw new  IllegalArgumentException(parameterName);
        }

        return value;
    }
}
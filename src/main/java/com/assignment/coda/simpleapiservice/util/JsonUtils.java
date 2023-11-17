package com.assignment.coda.simpleapiservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static boolean isValid(String string) {
        try {
            mapper.readTree(string);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}

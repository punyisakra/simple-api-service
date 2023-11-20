package com.assignment.coda.simpleapiservice.simple.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

/**
 * Utility class to provide JSON validation
 * */
public abstract class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Validate if the input string is in a valid JSON format
     * @param string an input {@link String} to be validated
     * @return true if the input string is a valid JSON; else false
     */
    public static boolean isValid(String string) {

        if (Objects.isNull(string) || Strings.isBlank(string.trim())) return false;

        try {
            mapper.readTree(string);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}

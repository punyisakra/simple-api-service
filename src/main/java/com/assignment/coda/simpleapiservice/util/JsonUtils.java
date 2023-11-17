package com.assignment.coda.simpleapiservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public abstract class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

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

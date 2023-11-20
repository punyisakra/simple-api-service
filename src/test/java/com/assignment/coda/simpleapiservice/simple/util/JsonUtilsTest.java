package com.assignment.coda.simpleapiservice.simple.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
class JsonUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"{}", "[]", "{\"k\":\"v\"}", "{\"k\":null}", "{\"k\":true}"})
    public void isValid_validString_returnTrue(String input) {
        assertThat(JsonUtils.isValid(input), is(true));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n", "abc", "{k:v"})
    public void isValid_invalidString_returnFalse(String input) {
        assertThat(JsonUtils.isValid(input), is(false));
    }
}
package com.assignment.coda.simpleapiservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postSimpleValidJson_returnSuccess() throws Exception {
        String jsonPayload = "{\"test1\":1, \"test2\":2.0, \"test3\": \"tmp\", \"test4\": []}";
        mockMvc.perform(post("/simples")
                .contentType(MediaType.TEXT_PLAIN)
                .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonPayload));
    }

    @Test
    public void postSimpleInvalidJson_returnBadRequest() throws Exception {
        String textPayload = "abcd1234";
        mockMvc.perform(post("/simples")
                .contentType(MediaType.TEXT_PLAIN)
                .content(textPayload))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(textPayload));
    }
}
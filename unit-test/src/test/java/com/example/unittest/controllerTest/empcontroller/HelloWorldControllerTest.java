package com.example.unittest.controllerTest.empcontroller;


import com.example.unittest.controller.HelloWroldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWroldController.class)
@ContextConfiguration(classes = HelloWroldController.class)
public class HelloWorldControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Test
    public void helloWorldTest() throws Exception {
        //Call /hell-world
        //verity return string

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
                        .accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

    assertEquals("Hellow World",  result.getResponse().getContentAsString());
    }

}

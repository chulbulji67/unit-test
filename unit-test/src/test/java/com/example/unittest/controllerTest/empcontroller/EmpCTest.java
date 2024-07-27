package com.example.unittest.controllerTest.empcontroller;

import com.example.unittest.UnitTestApplication;
import com.example.unittest.controller.HelloWroldController;
import com.example.unittest.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UnitTestApplication.class)
@ContextConfiguration(classes = HelloWroldController.class)
public class EmpCTest {

    @Autowired
    private MockMvc mockMvc;

//    @Mock
//    EmployeeRepo employeeRepo;

    @InjectMocks
    UnitTestApplication unitTestApplication;

    @Test
    public void helloWorldTest() throws Exception {
        //Call /hell-world
        //verity return string

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertEquals("Hellow World",  result.getResponse().getContentAsString());
    }
}

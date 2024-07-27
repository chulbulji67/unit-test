package com.example.unittest.controllerTest.item;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void contextLoads() throws JSONException {
      String response =  this.restTemplate.getForObject("/item-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001, name:Item1, price:10}, {id:10002, name:Item2, price:5}, {id:10003, name:Item3, price:15}]", response, false);
    }
}

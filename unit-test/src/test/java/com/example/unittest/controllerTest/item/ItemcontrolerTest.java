package com.example.unittest.controllerTest.item;

import com.example.unittest.business.ItemBusinessService;
import com.example.unittest.controller.ItemController;
import com.example.unittest.entity.Item;
import com.example.unittest.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemcontrolerTest.class)
@ContextConfiguration(classes = ItemController.class)
public class ItemcontrolerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @MockBean
    private ItemService itemService;


    @Test
    public void itemTestController() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"price\":49,\"qty\":3,\"name\":\"Ball\"}"))
                .andReturn();
        System.out.println("Output "+result.getResponse().toString());

    }

    @Test
    public void itemFromBusinessService() throws Exception {
        when(itemBusinessService.retreiveHardcodedItem()).thenReturn(new Item(2, "item2", 10, 10));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,price:10,name:item2,qty:10}"))
//                .andExpect(content().string("{\"id\":1,\"price\":49,\"qty\":3,\"name\":\"Ball\"}"))
                .andReturn();
        System.out.println("Output "+result.getResponse().toString());

    }

    @Test
    public void itemFromdataBaseService() throws Exception {
        when(itemService.retreiveAllItem()).thenReturn(Arrays.asList(new Item(2, "item2", 10, 10), new Item(3, "item1", 10, 10)));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[ {id:3,price:10,name:item1,qty:10},{id:2,price:10,name:item2,qty:10}]"))
//                .andExpect(content().string("{\"id\":1,\"price\":49,\"qty\":3,\"name\":\"Ball\"}"))
                .andReturn();
        System.out.println("Output "+result.getResponse().toString());

    }
}

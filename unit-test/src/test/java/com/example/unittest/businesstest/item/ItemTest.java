package com.example.unittest.businesstest.item;


import com.example.unittest.entity.Item;
import com.example.unittest.repository.ItemRepo;
import com.example.unittest.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemTest {

    @Mock
    ItemRepo itemRepo;

    @InjectMocks
    ItemService itemService;

    @Test
    void retreiveAllItemTest(){
        when(itemRepo.findAll()).thenReturn(Arrays.asList(new Item(2, "item2", 10, 10), new Item(3, "item1", 5, 10)));
        List<Item> items = itemService.retreiveAllItem();

        assertEquals(100, items.get(0).getValue());
        assertEquals(50, items.get(1).getValue());

    }
}

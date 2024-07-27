package com.example.unittest.business;

import com.example.unittest.entity.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retreiveHardcodedItem() {
        return  new Item(1, "Ball", 49, 3);
    }
}

package com.example.unittest.service;

import com.example.unittest.entity.Item;
import com.example.unittest.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public List<Item> retreiveAllItem(){
        List<Item> items = itemRepo.findAll();
        for (Item item: items
        ) {
            item.setValue(item.getQty()*item.getPrice());
        }
        return items;
    }
}

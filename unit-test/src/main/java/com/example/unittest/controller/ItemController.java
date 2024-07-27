package com.example.unittest.controller;

import com.example.unittest.business.ItemBusinessService;
import com.example.unittest.entity.Item;
import com.example.unittest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @Autowired
    ItemService itemService;

    @GetMapping("/dummy-item")
    public ResponseEntity<?> getDummyItem(){
        return ResponseEntity.status(200).body( new Item(1, "Ball", 49, 3));
    }

    @GetMapping("/item-from-business-service")
    public ResponseEntity<?> itemFromBusinessService(){
        return ResponseEntity.status(200).body( itemBusinessService.retreiveHardcodedItem());
    }

    @GetMapping("/item-from-database")
    public ResponseEntity<?> itemFromDatabase(){
        List<Item> items = itemService.retreiveAllItem();

        return ResponseEntity.status(200).body(items );
    }
}

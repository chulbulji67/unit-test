package com.example.unittest.datalayer;

import com.example.unittest.entity.Item;
import com.example.unittest.repository.ItemRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    ItemRepo itemRepo;
    @Test
    void testFindAll(){
        List<Item> items= itemRepo.findAll();
        assertEquals(3, items.size());
    }
}

package com.example.item_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.item_manager.entity.Item;
import com.example.item_manager.service.ItemService;

@SpringBootTest
class ItemManagerApplicationTests {
	
	@Autowired
    private ItemService itemService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testFindById() {
		Item item = itemService.findById(2);
	}

}

package com.cdac.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemDTO;

@SpringBootTest
class TestFoodItemService {
	@Autowired
	private FoodItemService foodItemService;

	@Test
	void testAddFoodItem() {
		FoodItemDTO dto=new FoodItemDTO("Ragi Dosa", "Healthy dosa",
				true, 100);
		ApiResponse resp = foodItemService.addFoodItem(3l, dto);
		assertEquals(true, resp.getMessage().contains("Added"));
	}

}

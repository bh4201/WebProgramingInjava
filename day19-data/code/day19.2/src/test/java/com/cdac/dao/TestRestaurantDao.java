package com.cdac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cdac.entities.Restaurant;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestRestaurantDao {
	//depcy
	@Autowired
	private RestaurantDao restaurantDao;

	@Test
	void testFetchCompleteDetails() {
		Restaurant restaurant = restaurantDao
				.fetchCompleteDetails(3l).get();
		//expected -2  actual 
		assertEquals(2,restaurant.getFoodItems().size());
	}

}

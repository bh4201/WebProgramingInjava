package com.cdac.service;

import java.util.List;

import com.cdac.dto.ApiResponse;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> findAllRestaurants();
	
	List<Restaurant>  findAllRestaurantsByKeyword();

	String addRestaurant(Restaurant restaurant);

	String deleteDetails(Long restaurantID);

	Restaurant getRestaurantDetails(Long id);

	ApiResponse updateDetails(Long restaurantId, Restaurant restaurant);
}

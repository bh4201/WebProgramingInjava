package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
import com.cdac.entities.Restaurant;


@Service // to declare a spring bean containing B.L
@Transactional // to auto manage txs (TransactioManager bean - spring supplied)
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao restaurantDao;
	@Override
	public List<Restaurant> findAllRestaurants() {
	
		
		return restaurantDao.findByStatusTrue() ;
	}

	@Override
	public List<Restaurant> findAllRestaurantsByKeyword() {
		// TODO Auto-generated method stub
		return restaurantDao.findByDescriptionContaining(null);
	}

	@Override
	public String addRestaurant(Restaurant restaurant) {
		if(restaurantDao.existsByName(restaurant.getName()))
			throw new ApiException("Dup restaturant Name!!1");
		//call dao method
		restaurant.setStatus(true);
		Restaurant restaurant2=restaurantDao.save(restaurant);
		
		return "added new restaurant with generated ID"+restaurant2.getId();
	}

	@Override
	public String deleteDetails(Long restaurantID) {
		if(restaurantDao.existsById(restaurantID)) {
			restaurantDao.deleteById(restaurantID);
			return "Delete restauranted details....";
		}
		throw new ResourceNotFoundException("Deleteion Failed");
		
	}

	@Override
	public Restaurant getRestaurantDetails(Long id) {
		//
		return restaurantDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("invalid id"));
		 
	}

	@Override
	public ApiResponse updateDetails(Long restaurantId, Restaurant restaurant) {
		if(restaurantDao.existsById(restaurantId)) {
		Restaurant restaurant2 = 	restaurantDao.save(restaurant);
		return new ApiResponse("Updated Restauraent sucessfulyy  !!!!");
		}
		throw new ResourceNotFoundException( "Ivalid Credentials");
	}


}

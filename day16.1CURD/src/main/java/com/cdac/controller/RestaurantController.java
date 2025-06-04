package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.ApiResponse;
import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@RestController
/*
 * =@Controller
 * +
 * @ResponseBody  implicitly added on return types of all equest
 * handeling method
 * =meant for selization : java to JSON| XML
 * */

@RequestMapping("/restaurants")
public class RestaurantController {

	//depcy-service layer layer
	@Autowired
	private RestaurantService restaurantService ;
	
	
	public  RestaurantController() {
		System.out.println("in constric of"+getClass());
	}
	/*
	 * Add REST API end point
	 * URL-http://host:port
	 * */
	@GetMapping
	public ResponseEntity<?> getAvailableRestaturant(){
		System.out.println("in get available");
		List<Restaurant> restaurants=	 restaurantService.findAllRestaurants();
		if(restaurants.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(restaurants);
	}
	//add new ressturant
	@PostMapping
	public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant restaurant)
	{
		try {
			System.out.println("add new restaurant "+getClass());
			return ResponseEntity.status(HttpStatus.CREATED) 
					.body(new ApiResponse(restaurantService.addRestaurant(restaurant)));

		}
		catch(RuntimeException e) {
			System.out.println("err in controller"+e);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}

	}
	//Delete
	@DeleteMapping("/{restaurantID}")
	public ResponseEntity<?> deleteRestaurantDetails(@PathVariable Long restaurantID) {
	
		try {
			return ResponseEntity.ok(
					restaurantService.deleteDetails(restaurantID));
		}
		catch (RuntimeException e) {
			System.out.println("err"+e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	//Updete the existing restaurant
	@GetMapping("/{id}")
	public ResponseEntity<?> getRestaurantDetails(@PathVariable Long id){
		System.out.println("int get details "+id);
		//call service layer method
		try {
			return ResponseEntity.ok(restaurantService.getRestaurantDetails(id));
		}
		catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	//Update bty taking the id above
	@PutMapping("/{restaurantId}")
	public ResponseEntity<?> updateDetails(@PathVariable Long restaurantId,
			@RequestBody Restaurant restaurant)
	{
		System.out.println("in update "+restaurantId+" "+restaurant);
		try {
			return ResponseEntity.ok
			(restaurantService.
					updateDetails(restaurantId,restaurant));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
}

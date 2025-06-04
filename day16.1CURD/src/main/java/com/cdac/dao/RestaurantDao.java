package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Restaurant;
public interface RestaurantDao extends JpaRepository<Restaurant ,Long>{
List<Restaurant> findByStatusTrue();

List<Restaurant> findByDescriptionContaining(String keyword);
//exixt by name
boolean existsByName(String restaurantName);
}

package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

public interface FoodItemDao extends JpaRepository<FoodItem,Long>{
 
}

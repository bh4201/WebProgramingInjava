package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Order;

public interface OrderDao extends JpaRepository<Order,Long> {

}

package com.example.service;

import com.example.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order save(Order order);


}

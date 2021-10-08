package com.example.controller;

import com.example.dto.OrderDto;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Override
    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    @PostMapping
    public Order save(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        User user = userService.findById(orderDto.getUserId());
        user.setPhoneNumber("999999999");
        user.setAddress("Bien Hoa - Tp Ho Chi Minh");
        user.setAge(24);
        order.setUser(user);
        order.setTotalPrice(orderDto.getTotalPrice());
        return orderService.save(order);
    }
}

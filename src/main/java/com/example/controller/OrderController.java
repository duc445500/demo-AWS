package com.example.controller;

import com.example.dto.OrderDto;
import com.example.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Requirement success"),
        @ApiResponse(responseCode = "400", description = "Bad request")
})
public interface OrderController {
    @Operation(summary = "find all order.", description = "Return list all order")
    List<Order> findAll();

    @Operation(summary = "Save or update requested order.", description = "Return new saved order.")
    Order save(OrderDto orderDto);
}

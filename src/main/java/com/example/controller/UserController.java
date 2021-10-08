package com.example.controller;

import com.example.dto.UserDto;
import com.example.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Requirement success"),
        @ApiResponse(responseCode = "400", description = "Bad request")
})
public interface UserController {
    @Operation(summary = "find all user.", description = "Return list all user")
    List<UserDto> findAll();

    @Operation(summary = "find order by user id.", description = "Return user")
    UserDto findById(long id);

    @Operation(summary = "Save requested user.", description = "Return new user")
    UserDto save(UserDto userDto);

    @Operation(summary = "Update user by requested id.", description = "Return updated user")
    UserDto modifyById(UserDto userDto);

    @Operation(summary = "Disable order by requested id.", description = "Return disabled user")
    UserDto disableById(long id);
}

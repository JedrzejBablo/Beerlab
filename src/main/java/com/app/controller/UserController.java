package com.app.controller;

import com.app.model.dto.OrderDto;
import com.app.model.dto.UserDto;
import com.app.security.CurrentUser;
import com.app.security.CustomUserDetails;
import com.app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "Get information about user",
            response = UserDto.class
    )
    @GetMapping("/me")
    public UserDto getUserInformation(@ApiIgnore @CurrentUser CustomUserDetails userDetails) {
        return userService.getUserInformation(userDetails.getId());
    }

    @ApiOperation(
            value = "Get user balance ",
            response = Double.class
    )
    @GetMapping("/balance")
    public Double getUserBalance(@ApiIgnore @CurrentUser CustomUserDetails userDetails) {
        return userService.getUserBalance(userDetails.getId());
    }
}

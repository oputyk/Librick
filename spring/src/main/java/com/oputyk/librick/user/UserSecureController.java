package com.oputyk.librick.user;

import com.oputyk.librick.security.service.authenticationfacade.AuthenticationFacade;
import com.oputyk.librick.user.dto.UserDto;
import com.oputyk.librick.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kamil on 17/02/2018.
 */

@RestController
@RequestMapping("user/secure")
public class UserSecureController {
    @Autowired
    private UserService userService;

    @PostMapping("current")
    public UserDto getUser() {
        return userService.findCurrentUserDto();
    }

    @GetMapping("get")
    public String get() {
        return "hi secured!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
         return userService.findUserDtoById(id);
    }
}

package com.oputyk.librick.user;

import com.oputyk.librick.user.domain.UserRepository;
import com.oputyk.librick.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kamil on 17/02/2018.
 */

@RestController
@RequestMapping("user/secure")
public class UserSecureController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
         return null;
    }
}

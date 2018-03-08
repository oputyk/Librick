package com.oputyk.librick.user;

import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kamil on 17/02/2018.
 */

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("add")
    public void add() {
        ArrayList<Role> roles = new ArrayList<>(Arrays.asList(Role.ROLE_LIBRARIAN));
        UserEntity userEntity = new UserEntity(1L, "user@email.com", encoder.encode("user"), roles);

        userRepository.save(userEntity);
    }
}

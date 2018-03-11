package com.oputyk.librick.user.service;

import com.oputyk.librick.security.service.authenticationfacade.AuthenticationFacade;
import com.oputyk.librick.user.converter.UserConverter;
import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.domain.UserRepository;
import com.oputyk.librick.user.dto.CredentialsUserDto;
import com.oputyk.librick.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kamil on 11/02/2018.
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    public UserDto findCurrentUserDto() {
        Authentication authentication = authenticationFacade.getAuthentication();

        return findUserDtoByEmail(authentication.getName());
    }

    @Override
    public UserDto findUserDtoByEmail(String email) {
        UserEntity userEntity = findUserEntityByEmail(email);

        return userConverter.toUserDto(userEntity);
    }

    @Override
    public boolean registerLibrarian(CredentialsUserDto credentialsUserDto) {
        return registrationService.registerUser(credentialsUserDto, Role.ROLE_LIBRARIAN);
    }

    @Override
    public UserEntity findUserEntityByEmail(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    @Override
    public UserDto findUserDtoById(Long id) {
        UserEntity userEntity = userRepository.findOne(id);

        return userConverter.toUserDto(userEntity);
    }
}

package com.oputyk.librick.user.service;

import com.oputyk.librick.user.converter.UserConverter;
import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.domain.UserRepository;
import com.oputyk.librick.user.dto.CredentialsUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kamil on 11/03/2018.
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private PasswordEncoder encoder;
    private UserConverter userConverter;
    private UserRepository userRepository;

    @Autowired
    public RegistrationServiceImpl(PasswordEncoder encoder, UserConverter userConverter, UserRepository userRepository) {
        this.encoder = encoder;
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public boolean registerUser(CredentialsUserDto credentialsUserDto, Role... roles) {
        if(!doesUserExist(credentialsUserDto.getEmail())) {
            decodePasswordIn(credentialsUserDto);

            UserEntity userEntity = userConverter.toUserEntity(credentialsUserDto);
            userEntity.setRoles(new ArrayList<>(Arrays.asList(roles)));

            return true;
        } else {
            return false;
        }
    }

    private boolean doesUserExist(String email) {
        return userRepository.findUserEntityByEmail(email) != null;
    }

    private void decodePasswordIn(CredentialsUserDto credentialsUserDto) {
        credentialsUserDto.setPassword(encoder.encode(credentialsUserDto.getPassword()));
    }
}

package com.oputyk.librick.user.service;

import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.dto.CredentialsUserDto;

/**
 * Created by kamil on 11/03/2018.
 */

public interface RegistrationService {
    boolean registerUser(CredentialsUserDto credentialsUserDto, Role ...roles);
}

package com.oputyk.librick.security.service.authenticationfacade;

import org.springframework.security.core.Authentication;

/**
 * Created by kamil on 01/03/2018.
 */

public interface AuthenticationFacade {
    Authentication getAuthentication();
}

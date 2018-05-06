package com.oputyk.librick.security.service;

import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 17/02/2018.
 */

@Transactional(readOnly = true)
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findUserEntityByEmail(email);
        if(userEntity != null) {
            return userEntityToUserDetails(userEntity);
        } else {
            throw new UsernameNotFoundException("UserEntity not found for the email - " + email);
        }
    }

    private UserDetails userEntityToUserDetails(UserEntity userEntity) {
        List<SimpleGrantedAuthority> authorities = rolesToAuthorities(userEntity.getRoles());

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

    private List<SimpleGrantedAuthority> rolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

}

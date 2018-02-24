package com.oputyk.librick.user.service;

import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.security.service.UserDetailsServiceImpl;
import com.oputyk.librick.user.domain.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 16/02/2018.
 */

@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {
    @MockBean
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @TestConfiguration
    static class UserDetailsServiceImplTestConfig {
        @Bean
        public UserDetailsService userDetailsServiceImpl() {
            return new UserDetailsServiceImpl();
        }
    }

    @Before
    public void setUp() {
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("abc@email.com")
                .password("admin")
                .roles(Arrays.asList(Role.ROLE_LIBRARIAN))
                .build();

        Mockito.when(userService.findUserEntityByEmail(userEntity.getEmail()))
                .thenReturn(userEntity);
    }

    @Test
    public void whenLoadUserByUsername_thenReturnUserDetails() {
        String email = "abc@email.com";

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        assertThat(userDetails.getUsername()).isEqualTo("abc@email.com");
        assertThat(userDetails.getPassword()).isEqualTo("admin");
    }

    @Test(expected = UsernameNotFoundException.class)
    public void whenLoadUserByUsername_thenThrowAnException() {
        String email = "def@email.com";

        assertThat(userDetailsService.loadUserByUsername(email));
    }
}

package com.oputyk.librick.user.converter;

import com.oputyk.librick.common.converter.EntityDtoConverter;
import com.oputyk.librick.user.domain.Role;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.domain.UserRepository;
import com.oputyk.librick.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 01/03/2018.
 */

@RunWith(SpringRunner.class)
public class UserConverterImplTest {
    @Autowired
    private UserConverter userConverter;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EntityDtoConverter entityDtoConverter;

    private UserEntity userEntity;
    private UserDto userDto;
    private UserEntity oldUserEntity;

    private final Long userId = 1L;
    private final String userEmail = "email@email.com";
    private final String userPassword = "password";
    private final ArrayList<Role> userRoles = new ArrayList<>(Arrays.asList(Role.ROLE_LIBRARIAN));

    private final Long oldUserId = 2L;
    private final String oldUserEmail = "email2@email.com";
    private final String oldUserPassword = "password2";
    private final ArrayList<Role> oldUserRoles = new ArrayList<>();

    @TestConfiguration
    public static class UserConverterImplTestConfig {
        @Bean
        public UserConverter userConverterImpl() {
            return new UserConverterImpl();
        }
    }

    @Before
    public void setUp() throws Exception {
        initUserEntity();
        initUserDto();
        initOldUserEntity();
    }

    @Test
    public void testToUserDto() throws Exception {
        Mockito.when(userRepository.findOne(userId))
                .thenReturn(userEntity);

        Mockito.when(entityDtoConverter.toDto(userEntity, UserDto.class))
                .thenReturn(userDto);

        UserDto convertedUserDto = userConverter.toUserDto(userEntity);

        assertThat(convertedUserDto).isEqualToComparingFieldByField(userDto);
    }

    @Test
    public void testToUserEntity() throws Exception {
        Mockito.when(userRepository.findOne(oldUserId))
                .thenReturn(oldUserEntity);

        Mockito.when(entityDtoConverter.toEntity(oldUserEntity, userDto))
                .thenReturn(userEntity);

        UserEntity convertedUserEntity = userConverter.toUserEntity(userDto);

        assertThat(convertedUserEntity).isEqualToComparingFieldByField(userEntity);
    }

    private void initUserEntity() {
        userEntity = new UserEntity(userId, userEmail, userPassword, userRoles);
    }

    private void initUserDto() {
        userDto = new UserDto(userId, userEmail, userRoles);
    }

    private void initOldUserEntity() {
        oldUserEntity = new UserEntity(oldUserId, oldUserEmail, oldUserPassword, oldUserRoles);
    }

}
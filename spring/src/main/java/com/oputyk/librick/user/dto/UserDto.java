package com.oputyk.librick.user.dto;

import com.oputyk.librick.user.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String email;
    private List<Role> roles = new ArrayList<>();
}

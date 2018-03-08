package com.oputyk.librick.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kamil on 08/03/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CredentialsUserDto {
    private String email;
    private String password;
}

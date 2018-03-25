package com.oputyk.librick.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordUserDto {
    private String oldPassword;
    private String newPassword;
}

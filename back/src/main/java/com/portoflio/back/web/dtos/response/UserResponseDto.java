package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.AppUser;
import com.portoflio.back.helpers.Helpers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private String image;

    public static UserResponseDto toDto(AppUser user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                Helpers.setImageFromBytes(user.getImage())
        );
    }
}

package com.adondevamos.adondevamos.utils;

import com.adondevamos.adondevamos.Dto.UserDTO;
import com.adondevamos.adondevamos.core.User.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .birthdate(user.getBirthdate())
                .sex(user.getSex())
                .phone(user.getPhone())
                .location(user.getLocation())
                .bio(user.getBio())
                .occupation(user.getOccupation())
                .languages(user.getLanguages())
                .categories(user.getCategories())
                .build();
    }
}


package com.adondevamos.adondevamos.utils;

import com.adondevamos.adondevamos.Dto.UserDTO;
import com.adondevamos.adondevamos.Entities.User;
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
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthdate(user.getBirthdate())
                .sex(user.getSex())
                .phone(user.getPhone())
                .location(user.getLocation())
                .bio(user.getBio())
                .occupation(user.getOccupation())
                .languages(user.getLanguages())
                .interests(user.getInterests())
                .build();
    }
}


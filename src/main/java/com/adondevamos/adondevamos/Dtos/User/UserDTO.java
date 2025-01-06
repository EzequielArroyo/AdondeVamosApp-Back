package com.adondevamos.adondevamos.Dtos.User;

import com.adondevamos.adondevamos.Entities.User;
import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String lastName;
    private String email;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}


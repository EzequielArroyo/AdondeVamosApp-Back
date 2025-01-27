package com.adondevamos.adondevamos.Dtos.User;

import com.adondevamos.adondevamos.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;

}


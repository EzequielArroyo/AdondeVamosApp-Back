package com.adondevamos.adondevamos.Auth;

import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
    UserDTO userData;
}

package com.adondevamos.adondevamos.Dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder
public class UserResponseDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthdate;
    private String sex;
    private String phone;
    private String location;
    private List<String> languages;
    private String bio;
    private String occupation;
    private List<String> interests;
}

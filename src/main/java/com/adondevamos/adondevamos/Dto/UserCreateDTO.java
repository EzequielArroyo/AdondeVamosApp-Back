package com.adondevamos.adondevamos.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDTO {
    private String username;
    private String password;
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

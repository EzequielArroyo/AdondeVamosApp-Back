package com.adondevamos.adondevamos.Dto;

import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Entities.Language;
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
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthdate;
    private String sex;
    private String phone;
    private String location;
    private List<Language> languages;
    private String bio;
    private String occupation;
    private List<Interest> interests;
}

package com.adondevamos.adondevamos.Auth;


import com.adondevamos.adondevamos.core.Category.Category;
import com.adondevamos.adondevamos.core.Language.Language;
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
public class RegisterRequest {
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
    private List<Category> categories;
}

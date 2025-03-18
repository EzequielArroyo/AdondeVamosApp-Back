package com.adondevamos.adondevamos.Dto;

import com.adondevamos.adondevamos.core.Category.Category;
import com.adondevamos.adondevamos.core.Language.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String sex;
    private String phone;
    private String location;
    private String bio;
    private String occupation;
    private List<Language> languages;
    private List<Category> categories;
}

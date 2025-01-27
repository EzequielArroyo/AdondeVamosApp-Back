package com.adondevamos.adondevamos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false)
    private String sex;

    private String phone;

    private String location;
    @ElementCollection
    private List<String> languages;

    @Column(length = 500) // Limitar el tamaño del campo bio
    private String bio;

    private String occupation;
    @ElementCollection
    private List<String> interests;
}

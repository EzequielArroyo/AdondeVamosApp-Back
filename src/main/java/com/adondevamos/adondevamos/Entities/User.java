package com.adondevamos.adondevamos.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Setter
    @Column(name = "userName")
    private String userName;

    @Setter
    @Column(name = "lastName")
    private String lastName;

    @Setter
    @Column(name = "email")
    private String email;

    @Setter
    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "joinedUsers", fetch = FetchType.LAZY)
    private List<Post> joinedPost;

}

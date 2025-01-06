package com.adondevamos.adondevamos.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "title")
    @Setter
    private String title;

    @ManyToOne
    @JoinColumn(name = "createBy")
    @Setter
    private User createBy;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "post_users", // Name of the intermediate table
            joinColumns = @JoinColumn(name = "post_id"), // Primary key of Post
            inverseJoinColumns = @JoinColumn(name = "user_id"))// Primary key of User
    @Setter
    private List<User> joinedUsers;


}

package com.adondevamos.adondevamos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime datetime;

    private String description;

    private String location;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "activity_participants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<User> participants;

    @Column(nullable = false)
    private Integer maxParticipants;

    @Column(nullable = false)
    private String category;

    public void joinActivity(User user){
        this.participants.add(user);
    }
    public void leaveActivity(User user){
        this.participants.remove(user);
    }

}

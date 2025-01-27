package com.adondevamos.adondevamos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private Integer participants;

    @Column(nullable = false)
    private Integer maxParticipants;

    @Column(nullable = false)
    private String category;
}

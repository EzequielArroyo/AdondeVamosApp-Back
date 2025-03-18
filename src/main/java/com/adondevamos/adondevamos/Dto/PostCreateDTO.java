package com.adondevamos.adondevamos.Dto;


import com.adondevamos.adondevamos.core.Category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDTO {
    private String title;
    private LocalDateTime datetime;
    private String description;
    private String location;
    private String ownerUsername;
    private Integer maxParticipants;
    private Category category;
}

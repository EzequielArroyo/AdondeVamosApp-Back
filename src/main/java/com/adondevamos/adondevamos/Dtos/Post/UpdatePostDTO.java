package com.adondevamos.adondevamos.Dtos.Post;

import lombok.Data;

import java.util.List;

@Data
public class UpdatePostDTO {
    private String title;
    private List<Long> participantsId;
}

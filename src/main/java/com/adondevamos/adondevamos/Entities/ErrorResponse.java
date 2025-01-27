package com.adondevamos.adondevamos.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private String detail;
}

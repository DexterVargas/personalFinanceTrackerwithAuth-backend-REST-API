package com.dexterv.financetracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String message;
    private String path;
    private int  status;
    private LocalDateTime timestamp;
}

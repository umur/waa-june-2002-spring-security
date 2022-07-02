package com.cs545waa.lab06.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffensiveRequestDTO {
    private Long id;
    private String username;
    private String request;
}

package com.example.lab6.dto;


import com.sudip.lab5.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDtoResponse {
    private User user;
}

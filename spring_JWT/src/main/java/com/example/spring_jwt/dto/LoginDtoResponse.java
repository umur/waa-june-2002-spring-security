package com.example.spring_jwt.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDtoResponse {
  private String accessToken;
  private String refreshToken;
}

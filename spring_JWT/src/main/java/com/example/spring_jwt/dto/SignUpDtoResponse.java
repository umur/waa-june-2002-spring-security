package com.pprajapati.springsecurity.dto;

import com.pprajapati.springsecurity.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDtoResponse {
  private User user;
}

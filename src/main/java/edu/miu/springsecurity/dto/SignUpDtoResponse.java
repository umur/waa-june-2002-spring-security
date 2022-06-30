package edu.miu.springsecurity.dto;

import edu.miu.springsecurity.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDtoResponse {
    private User user;
}
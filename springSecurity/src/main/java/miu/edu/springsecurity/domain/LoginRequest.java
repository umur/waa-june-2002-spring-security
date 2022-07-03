package miu.edu.springsecurity.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String email;

    private String password;

}

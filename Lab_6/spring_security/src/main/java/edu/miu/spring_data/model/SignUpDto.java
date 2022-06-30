package edu.miu.spring_data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class SignUpDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname ;
    private int addressId ;
}

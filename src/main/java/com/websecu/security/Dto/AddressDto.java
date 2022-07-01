package com.websecu.security.Dto;


import com.websecu.security.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;
    private User user;
}

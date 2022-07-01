package com.websecu.security.Dto;


import com.websecu.security.Domain.Address;
import com.websecu.security.Domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Address address;

    private List<Review> reviews;
}

package edu.miu.spring_security.dto;


import edu.miu.spring_security.entity.Address;
import edu.miu.spring_security.entity.Product;
import edu.miu.spring_security.entity.Review;
import edu.miu.spring_security.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;

    private String email;
    private String firstname;
    private String lastname;

    private Address address;

    private List<Product> products;

    private List<Review> reviews;

    private List<Role> roles;
}

package com.cs545waa.lab06.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
   // @JsonIgnore
    @JsonManagedReference(value = "userAddress")
    private AddressDTO address;
    //@JsonIgnore
    @JsonManagedReference(value = "userReviews")
    private List<ReviewDTO> reviews;
    //@JsonIgnore
    @JsonManagedReference(value = "userProducts")
    private List<ProductDTO> products;
}

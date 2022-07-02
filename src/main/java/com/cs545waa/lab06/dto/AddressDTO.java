package com.cs545waa.lab06.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;
    @JsonBackReference(value = "userAddress")
    //@JsonIgnore
    private AppUserDTO appUser;
}

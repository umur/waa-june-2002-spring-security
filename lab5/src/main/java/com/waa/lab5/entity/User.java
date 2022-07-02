package com.waa.lab5.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    @OneToOne
    private Address address;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Role> roles = new ArrayList<>();
}

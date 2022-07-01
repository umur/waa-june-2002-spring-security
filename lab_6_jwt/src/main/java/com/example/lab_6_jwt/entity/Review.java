package com.example.lab_6_jwt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "review_id_seq",allocationSize = 1)
    private Long id;

    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}

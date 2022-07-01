package com.example.spring_jwt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="reviews")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String comment;
  @Column(name="number_of_stars")
  private int numberOfStars;

  @ManyToOne
//  @JsonBackReference
  private Product product;

}

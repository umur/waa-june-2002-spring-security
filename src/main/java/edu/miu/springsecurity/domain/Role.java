package edu.miu.springsecurity.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String role;
}

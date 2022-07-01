package com.websecu.security.Dto;


import com.websecu.security.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int id;
    private String comment;

    private User user;
}

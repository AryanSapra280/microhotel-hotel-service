package com.userservice.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

import com.userservice.UserService.dtos.Rating;

@Entity
@Table(name = "user_details")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) for String type column this doesn't work. Only works with int, long
    private String user_id;
    @Column(length = 15)
    private String name;
    @Column(unique = true)
    private String email;
    private String about;
    @Transient
    private List<Rating>ratings;
}

package com.userservice.UserService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
    private String ratingId;
    private String hotelId;
    private Integer ratingValue;
    private Integer userId;
    private String feedback;
}

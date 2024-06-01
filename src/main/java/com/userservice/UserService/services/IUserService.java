package com.userservice.UserService.services;

import java.util.*;

import com.userservice.UserService.entities.User;

public interface IUserService {
    List<User> getAllUser();
    User getUserById(String id);
    User saveUser(User user);
}

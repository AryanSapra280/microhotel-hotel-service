package com.userservice.UserService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.UserService.entities.User;
import com.userservice.UserService.exceptions.customException.UserNotFound;
import com.userservice.UserService.repositories.IUserRepositories;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepositories userRepositories;
    @Override
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    @Override
    public User getUserById(String id) {

        //one line solution
        return userRepositories.findById(id).orElseThrow(()->new UserNotFound("User doesn't exist with this id:" + id));
        
        // User foundUser = null;
        // try {
        //     foundUser = userRepositories.findById(id).get();
        // }catch(NullPointerException e) {
        //     throw new UserNotFound("User doesn't exist with this id:" + id);
        // }
        // return foundUser;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepositories.save(user);
        return savedUser;
    }
    
}

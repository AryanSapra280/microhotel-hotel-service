package com.userservice.UserService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.UserService.entities.User;
import com.userservice.UserService.exceptions.customException.DuplicateEmail;
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
        String userId = UUID.randomUUID().toString();
        user.setUser_id(userId);
        User savedUser = null;
        try {
            savedUser = userRepositories.save(user);
        }catch(Exception exception) {
            throw new DuplicateEmail("This email is already registered");
        }
        return savedUser;
    }
    
    @Override
    public User updateUser(User user) {
        if(user.getEmail() == null) {
            throw new RuntimeException("Please provide a registered email");
        }
        User foundUser = userRepositories.findByEmail(user.getEmail()).
        orElseThrow(()->new UserNotFound("user doesn't exist with this email"));
        updateDetails(foundUser,user);
        return userRepositories.save(foundUser);
    }
    private void updateDetails(User foundUser, User user) {
        if(user.getAbout()!=null) {
            foundUser.setAbout(user.getAbout());
        }
        if(user.getName()!=null) {
            foundUser.setName(user.getName());
        }
    }

}

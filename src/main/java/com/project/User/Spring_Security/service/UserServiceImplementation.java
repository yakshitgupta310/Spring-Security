package com.project.User.Spring_Security.service;

import com.project.User.Spring_Security.entity.User;
import com.project.User.Spring_Security.model.UserModel;
import com.project.User.Spring_Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) throws RuntimeException{
        User duplicatedUser = userRepository.getUserByEmail(userModel.getEmail());
        if(duplicatedUser != null){

            throw new RuntimeException("user with same email already exists");
        }
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(userModel.getPassword());
        //user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }
}

package com.project.User.Spring_Security.service;


import com.project.User.Spring_Security.entity.User;
import com.project.User.Spring_Security.model.UserModel;

public interface UserService {

    public User registerUser(UserModel userModel);
}

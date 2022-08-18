package com.example.springbootbatch.service.impl;

import com.example.springbootbatch.model.User;
import com.example.springbootbatch.repository.UserRepository;
import com.example.springbootbatch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

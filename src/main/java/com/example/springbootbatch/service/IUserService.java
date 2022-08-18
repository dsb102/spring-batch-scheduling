package com.example.springbootbatch.service;

import com.example.springbootbatch.model.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
}

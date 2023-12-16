package com.example.ProductApplication.service;

import com.example.ProductApplication.domain.User;

import java.util.List;

public interface IProductService
{
    public User addUser(User user);   // NOn-INtercepted
    public User getUserInfo(String email);   //intercepted URL
    public User updateUser(String email,User user);   // intercepted URL
    public List<User> getAllUsersInfo();
}

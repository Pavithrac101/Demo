package com.example.ProductApplication.service;

import com.example.ProductApplication.domain.User;
import com.example.ProductApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public User addUser(User user) {
        return productRepository.insert(user);
    }
    @Override
    public User getUserInfo(String email) {
        return productRepository.findById(email).get();
    }
    @Override
    public User updateUser(String email, User user) {
        User retrivedUser=productRepository.findById(email).get();
        if(user.getName()!=null)
        {
            retrivedUser.setName(user.getName());
        }
        if(user.getPhno()!=null)
        {
            retrivedUser.setPhno(user.getPhno());
        }
        if (user.getProducts()!=null)
        {
            retrivedUser.setProducts(user.getProducts());
        }
        return productRepository.save(retrivedUser);
    }

    @Override
    public List<User> getAllUsersInfo() {
        return productRepository.findAll();
    }
}

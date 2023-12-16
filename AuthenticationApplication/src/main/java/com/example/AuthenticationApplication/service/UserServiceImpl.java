package com.example.AuthenticationApplication.service;

import com.example.AuthenticationApplication.domain.SignUpData;
import com.example.AuthenticationApplication.domain.User;
import com.example.AuthenticationApplication.domain.UserDto;
import com.example.AuthenticationApplication.proxy.UserProxy;
import com.example.AuthenticationApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;

    @Override
    public User registerUserUsingFC(SignUpData signUpData) {
        UserDto userDto=new UserDto(signUpData.getEmail(), signUpData.getName(),signUpData.getPhno(),signUpData.getAddress());
        User user=new User(signUpData.getEmail(),signUpData.getPassword(),signUpData.getRole());

        ResponseEntity response= userProxy.sendUserDtoToProductApp(userDto);
        System.out.println(response);

       User user1= userRepository.save(user);
        return user1;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User checkLogin(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }
}

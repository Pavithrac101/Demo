package com.example.AuthenticationApplication.service;



import com.example.AuthenticationApplication.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {
    public Map<String,String> generateToken(User user);
}

package com.example.AuthenticationApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SignUpData
{
    private String email;
    private String password,role;
    private String name,phno,address;

}

package com.example.ProductApplication.controller;

import com.example.ProductApplication.domain.User;
import com.example.ProductApplication.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/prod/v1")
public class ProductController
{
    @Autowired
    private IProductService iProductService;

    //  http://localhost:5555/prod/v1/addUser   [post] requestbody
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user)
    {
        return new ResponseEntity(iProductService.addUser(user), HttpStatus.CREATED);
    }

    // intercepted http://localhost:5555/prod/v1/getUser     /{email}-not needed   [get] pathvariable
    @GetMapping("/getUser")
    public ResponseEntity getUserInformation(HttpServletRequest request)
    {
        System.out.println("hello");
        String email=(String) request.getAttribute("a");
        System.out.println("email is : "+email)
        ;
        return new ResponseEntity(iProductService.getUserInfo(email),HttpStatus.OK);
    }

    // intercepted  http://localhost:5555/prod/v1/updateUser       /{email}-not needed   [put] pathvariable,requestbody
    @PutMapping("/updateUser")
    public ResponseEntity updateUserInfo(@RequestBody User user,HttpServletRequest request)
    {
        String email=(String)request.getAttribute("a");
        return new ResponseEntity(iProductService.updateUser(email, user),HttpStatus.OK);
    }

    // intercepted:Authentication:  http://localhost:5555/prod/v1/getAllUsers  &  Authorization: role=admin
    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(HttpServletRequest request)
    {
        String role=(String)request.getAttribute("b");
        if(role.equals("Role_Admin")) {
            return new ResponseEntity(iProductService.getAllUsersInfo(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity("UR not Authorised to access this url",HttpStatus.BAD_REQUEST);
        }
    }
}

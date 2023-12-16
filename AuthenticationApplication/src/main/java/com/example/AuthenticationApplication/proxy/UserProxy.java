package com.example.AuthenticationApplication.proxy;

import com.example.AuthenticationApplication.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service",url = "localhost:5555")
public interface UserProxy
{
    @PostMapping("/prod/v1/addUser")
    public ResponseEntity sendUserDtoToProductApp(@RequestBody UserDto userDto);
}





//    //  http://localhost:5555/prod/v1/addUser   [post] requestbody
//    @PostMapping("/addUser")
//    public ResponseEntity addUser(@RequestBody User user)
//    {
//        return new ResponseEntity(iProductService.addUser(user), HttpStatus.CREATED);
//    }
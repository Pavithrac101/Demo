package com.example.AuthenticationApplication.repository;

import com.example.AuthenticationApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>
{
    //register a user ===>  user save(User user);

    //login check
    //1.  select pwd from user where email = *** ===>will retrive pwd for specific emailId
    //     then we can check pwd is correct or not
    //   findById(email)

    //2.   select * from user where email=**** && pwd=****
    //    it will retrive entire user obj[ email,pwd,role] if email & pwd matches
    //   custom methods ==> findByEmailAndPassword(email,password)

    public User findByEmailAndPassword(String email,String password);
}

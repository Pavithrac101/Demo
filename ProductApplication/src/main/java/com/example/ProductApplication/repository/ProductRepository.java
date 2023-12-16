package com.example.ProductApplication.repository;

import com.example.ProductApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<User,String> {
    // add a user ===> insert()  or save()
    // view all customer ===>findAll()

}

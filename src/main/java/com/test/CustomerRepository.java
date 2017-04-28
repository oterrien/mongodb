package com.test;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    @Query("{lastName : ?0 }")
    List<Customer> find(String lastName);

    @Query("{age : {$gte : ?0}}")
    List<Customer> findByAgeMin(int age);

}
package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Autowired
    private CustomerRepository repository;

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {

            log.info("Customers found with findAll():");
            repository.findAll().forEach(System.out::println);

            log.info("Remove all customers:");
            repository.deleteAll();

            log.info("Add 2 customers:");
            repository.save(new Customer("Alice", "Smith", 32));
            repository.save(new Customer("Bob", "Smith", 34));

            log.info("Customers found with findByFirstName('Alice'):");
            log.info(repository.findByFirstName("Alice").toString());

            log.info("Customers found with findByAgeMin(33):");
            log.info(repository.findByAgeMin(33).toString());


            // fetch all customers
           /* System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer);
            }
            System.out.println();*/

            /*// fetch an individual customer
            System.out.println("Customer found with findByFirstName('Alice'):");
            System.out.println("--------------------------------");
            System.out.println(repository.findByFirstName("Alice"));

            System.out.println("Customers found with findByLastName('Smith'):");
            System.out.println("--------------------------------");
            for (Customer customer : repository.findByLastName("Smith")) {
                System.out.println(customer);
            }*/
        };
    }
}

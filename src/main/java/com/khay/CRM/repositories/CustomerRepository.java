package com.khay.CRM.repositories;

import com.khay.CRM.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findCustomerByUsername(String Username);
}

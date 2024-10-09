package com.mockito.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockito.junit.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByUsername(String username);

}
package com.example.application1.repository;

import com.example.application1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findBySex(boolean sex);
    List<Customer> findByName(String name);
    Customer findCustomerById(Integer id);

}

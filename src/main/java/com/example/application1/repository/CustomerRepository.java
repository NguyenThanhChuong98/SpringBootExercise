package com.example.application1.repository;

import com.example.application1.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findBySex(boolean sex);
    List<Customers> findByName(String name);
    Customers findCustomerById(Integer id);

}

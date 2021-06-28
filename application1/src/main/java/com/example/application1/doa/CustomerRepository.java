package com.example.application1.doa;

import com.example.application1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findBySex(boolean sex);
    List<Customer> findByName(String name);
    Customer findCustomerById(long id);

}

package com.example.application1.repository;


import com.example.application1.model.Customers;
import com.example.application1.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoes, Integer> {
    List<Shoes> findByName(String name);
    Shoes findShoesById(Integer id);
}

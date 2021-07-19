package com.example.application1.repository;


import com.example.application1.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoesRepository extends JpaRepository<Shoes, Integer> {
    List<Shoes> findByName(String name);
    Shoes findShoeById(Integer id);
}

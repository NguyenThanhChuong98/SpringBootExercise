package com.example.application1.controller;

import com.example.application1.model.Shoes;
import com.example.application1.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShoesController {
    @Autowired
    ShoeRepository shoesRepository;

    @GetMapping("/shoes")
    public ResponseEntity<List<Shoes>> getAllShoes(@RequestParam(required = false) String name) {
        try {
            List<Shoes> shoes = new ArrayList<>();
            if (name == null)
                shoesRepository.findAll().forEach(shoes::add);
            else
                shoesRepository.findByName(name).forEach(shoes::add);
            if (shoes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(shoes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-shoes")
    public ResponseEntity<Shoes> createShoes(@RequestBody Shoes shoes) {
        try {
            Shoes _shoes = shoesRepository.save(new Shoes(shoes.getName(),
                    shoes.getForm(),
                    shoes.getMaterial(),
                    shoes.getHeels(),
                    shoes.getWeight(),
                    shoes.getPrice(),
                    shoes.getBrand(),
                    shoes.getSize(),
                    shoes.getDesc(),
                    shoes.getColor(),
                    shoes.getCreateDate(),
                    shoes.getUpdateDate()));
            return new ResponseEntity<>(_shoes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-shoes-by-id")
    public ResponseEntity<Shoes> deleteShoesById(@RequestParam Integer id) {
        try {
            Shoes shoes = shoesRepository.findShoesById(id);
            shoesRepository.delete(shoes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-shoes-by-id")
    public ResponseEntity<Shoes> updateShoesById(@RequestParam Integer id, @RequestBody Shoes shoes) {
        Optional<Shoes> shoesData = shoesRepository.findById(id);

        if (shoesData.isPresent()) {
            Shoes _shoes = shoesData.get();
            _shoes.setName(shoes.getName());
            _shoes.setForm(shoes.getForm());
            _shoes.setMaterial(shoes.getMaterial());
            _shoes.setHeels(shoes.getHeels());
            _shoes.setWeight(shoes.getWeight());
            _shoes.setPrice(shoes.getPrice());
            _shoes.setBrand(shoes.getBrand());
            _shoes.setSize(shoes.getSize());
            _shoes.setDesc(shoes.getDesc());
            _shoes.setColor(shoes.getColor());
            _shoes.setUpdateDate(shoes.getUpdateDate());

            return new ResponseEntity<>(shoesRepository.save(_shoes), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

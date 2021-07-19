package com.example.application1.controller;

import com.example.application1.entity.Shoes;
import com.example.application1.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShoeController {
    @Autowired
    ShoesRepository shoesRepository;

    @GetMapping("/Shoes")
    public ResponseEntity<List<Shoes>> getAllShoe(@RequestParam(required = false) String name) {
        try {
            List<Shoes> shoes = new ArrayList<Shoes>();
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

    @PostMapping("/create-shoe")
    public ResponseEntity<Shoes> createShoe(@RequestBody Shoes shoes) {
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
                    shoes.getQuantity(),
                    shoes.getCreateDate(),
                    shoes.getUpdateDate()));
            return new ResponseEntity<>(_shoes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-shoe-by-id")
    public ResponseEntity<Shoes> deleteShoeById(@RequestParam Integer id) {
        try {
            Shoes shoes = shoesRepository.findShoeById(id);
            shoesRepository.delete(shoes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-shoe-by-id")
    public ResponseEntity<Shoes> updateShoeById(@RequestParam Integer id, @RequestBody Shoes shoes) {
        Optional<Shoes> ShoeData = shoesRepository.findById(id);

        if (ShoeData.isPresent()) {
            Shoes _Shoe = ShoeData.get();
            _Shoe.setName(shoes.getName());
            _Shoe.setForm(shoes.getForm());
            _Shoe.setMaterial(shoes.getMaterial());
            _Shoe.setHeels(shoes.getHeels());
            _Shoe.setWeight(shoes.getWeight());
            _Shoe.setPrice(shoes.getPrice());
            _Shoe.setBrand(shoes.getBrand());
            _Shoe.setSize(shoes.getSize());
            _Shoe.setDesc(shoes.getDesc());
            _Shoe.setColor(shoes.getColor());
            _Shoe.setUpdateDate(shoes.getUpdateDate());

            return new ResponseEntity<>(shoesRepository.save(_Shoe), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

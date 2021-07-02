package com.example.application1.controller;

import com.example.application1.entity.Customers;
import com.example.application1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers(@RequestParam(required = false) String name) {
        try {
            List<Customers> customers = new ArrayList<Customers>();
            if (name == null)
                customerRepository.findAll().forEach(customers::add);
            else
                customerRepository.findByName(name).forEach(customers::add);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(customers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create-customer")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        try {
            Customers _customer = customerRepository.save(new Customers(customer.getAccount(),
                    customer.getPassword(),
                    customer.getName(),
                    customer.getDateOfBirth(),
                    customer.getPhone(),
                    customer.getAddress(),
                    customer.getSex(),
                    customer.getCreatedDate(),
                    customer.getUpdatedDate()));
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-customers")
    public ResponseEntity<Customers> deleteCustomer(@RequestParam Integer id) {
        try {
            Customers customer = customerRepository.findCustomerById(id);
            customerRepository.delete(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Customers> updateCustomer(@RequestParam Integer id, @RequestBody Customers customer) {
        Optional<Customers> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customers _customer = customerData.get();
            _customer.setName(customer.getName());
            _customer.setDateOfBirth(customer.getDateOfBirth());
            _customer.setPhone(customer.getPhone());
            _customer.setAddress(customer.getAddress());
            _customer.setSex(customer.getSex());
            _customer.setUpdateDate(customer.getUpdatedDate());

            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

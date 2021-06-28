package com.example.application1.controller;

import com.example.application1.doa.CustomerRepository;
import com.example.application1.model.Customer;
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
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(required = false) String name) {
        try {
            List<Customer> customers = new ArrayList<Customer>();
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
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerRepository.save(new Customer(customer.getAccount(),
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
    public ResponseEntity<Customer> deleteCustomer(@RequestParam Long id) {
        try {
            Customer customer = customerRepository.findCustomerById(id);
            customerRepository.delete(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
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

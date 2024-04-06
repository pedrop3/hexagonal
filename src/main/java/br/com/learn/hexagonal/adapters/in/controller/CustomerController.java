package br.com.learn.hexagonal.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.learn.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.learn.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, CustomerMapper customerMapper) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {

        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();

    }
    
}

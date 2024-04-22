package br.com.learn.hexagonal.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.learn.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.learn.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.learn.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.learn.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, CustomerMapper customerMapper,
            FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {

        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {

        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

}

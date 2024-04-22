package br.com.learn.hexagonal.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.learn.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.learn.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.learn.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.learn.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.learn.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, CustomerMapper customerMapper,
            FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerInputPort updateCustomerInputPort,
            DeleteCustomerByIdInputPort deleteCustomerByIdInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        deleteCustomerByIdInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}

package br.com.learn.hexagonal.adapters.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.learn.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.out.FindCustomerAllOutputPort;

@Component
public class FindCustomerAllAdapter implements FindCustomerAllOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerAllAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public List<Customer> all() {
        var customerListEntity = customerRepository.findAll();

        return customerListEntity.stream()
                .map(customerEntityMapper::toCustomer)
                .collect(Collectors.toList());
    }

}

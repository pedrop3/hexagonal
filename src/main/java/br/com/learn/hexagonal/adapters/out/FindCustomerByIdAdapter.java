package br.com.learn.hexagonal.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.learn.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdAdapter  implements FindCustomerByIdOutputPort{

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}

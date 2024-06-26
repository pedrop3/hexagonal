package br.com.learn.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.learn.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;

    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}

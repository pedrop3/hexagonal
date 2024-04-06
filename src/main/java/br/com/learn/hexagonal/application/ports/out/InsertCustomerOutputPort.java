package br.com.learn.hexagonal.application.ports.out;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    
    void insert(Customer customer);
}

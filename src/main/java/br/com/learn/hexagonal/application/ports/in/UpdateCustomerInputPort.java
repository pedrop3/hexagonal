package br.com.learn.hexagonal.application.ports.in;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    
    void update(Customer customer, String zipCode);
}

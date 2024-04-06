package br.com.learn.hexagonal.application.ports.in;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}

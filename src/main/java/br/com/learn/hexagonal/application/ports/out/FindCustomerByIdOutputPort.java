package br.com.learn.hexagonal.application.ports.out;

import java.util.Optional;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}

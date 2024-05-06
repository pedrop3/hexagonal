package br.com.learn.hexagonal.application.ports.out;

import java.util.List;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface FindCustomerAllOutputPort {

    List<Customer> all();
}

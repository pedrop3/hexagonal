package br.com.learn.hexagonal.application.ports.in;

import java.util.List;

import br.com.learn.hexagonal.application.core.domain.Customer;

public interface FindCustomerAllInputPort {

    List<Customer> all();

}

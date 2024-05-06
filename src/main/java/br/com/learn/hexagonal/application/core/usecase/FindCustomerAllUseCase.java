package br.com.learn.hexagonal.application.core.usecase;

import java.util.List;

import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.in.FindCustomerAllInputPort;
import br.com.learn.hexagonal.application.ports.out.FindCustomerAllOutputPort;

public class FindCustomerAllUseCase implements  FindCustomerAllInputPort {


    public final FindCustomerAllOutputPort findCustomerAllOutputPort;

    public FindCustomerAllUseCase(FindCustomerAllOutputPort findCustomerAllOutputPort) {
        this.findCustomerAllOutputPort = findCustomerAllOutputPort;

    }

    @Override
    public List<Customer> all() {
        return findCustomerAllOutputPort.all();
    }

}

package br.com.learn.hexagonal.application.core.usercase;

import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.learn.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.learn.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase  implements UpdateCustomerInputPort{

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerUseCase updateCustomerUseCase, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
    }

}

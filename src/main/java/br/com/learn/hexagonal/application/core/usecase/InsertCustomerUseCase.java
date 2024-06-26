package br.com.learn.hexagonal.application.core.usecase;

import br.com.learn.hexagonal.application.core.domain.Customer;
import br.com.learn.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.learn.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.learn.hexagonal.application.ports.out.InsertCustomerOutputPort;
import br.com.learn.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    // We do not utilize frameworks like Spring by @Authorid.
    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {

        /**
         * 
         * We need to retrieve the address from another microservice or API.
         * Consequently, we need to implement a new output port to facilitate this it.
         */
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        /**
         * We need to insert the client into the database, but we currently lack access
         * to the database. This pathway is integral to the core application. Therefore,
         * we require a new output port to facilitate the insertion of the client into
         * the database.
         */
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());

    }

}

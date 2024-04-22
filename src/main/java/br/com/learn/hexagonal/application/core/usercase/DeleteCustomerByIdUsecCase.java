package br.com.learn.hexagonal.application.core.usercase;

import br.com.learn.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.learn.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUsecCase implements DeleteCustomerByIdInputPort {

    public final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;
    public final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerByIdUsecCase(DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;

    }

    @Override
    public void delete(String id) {
        var customer = this.findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(customer.getId());
    }

}

package br.com.learn.hexagonal.adapters.in.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.learn.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.learn.hexagonal.application.ports.in.UpdateCustomerInputPort;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort,
            CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "pedrosantos")
    public void recive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}

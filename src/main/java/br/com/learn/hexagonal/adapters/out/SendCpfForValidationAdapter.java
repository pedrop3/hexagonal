package br.com.learn.hexagonal.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

    public final KafkaTemplate<String, String> kafkaTemplate;

    SendCpfForValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }

}

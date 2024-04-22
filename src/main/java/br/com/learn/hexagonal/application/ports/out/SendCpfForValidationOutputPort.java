package br.com.learn.hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {
    
    void send(String cpf);
}

package br.com.learn.hexagonal.adapters.in.controller.response;

import br.com.learn.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;

}

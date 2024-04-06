package br.com.learn.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest {

    @NotBlank
    private String name;
    
    @NotBlank
    private String cpf;
    
    @NotBlank
    private String zipCode;

}

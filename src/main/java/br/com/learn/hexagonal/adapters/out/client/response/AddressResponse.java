package br.com.learn.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data //We utilize Lombok here because this pathway is not part of the core.
public class AddressResponse {

    private String street;
    private String city;
    private String state;
    
}

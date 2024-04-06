package br.com.learn.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import br.com.learn.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.learn.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.learn.hexagonal.application.core.domain.Address;
import br.com.learn.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

//We utilize Spring here because this pathway is not part of the core.
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {


    private final FindAddressByZipCodeClient addressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient addressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.addressByZipCodeClient = addressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String code) {
        var addressResponse  = addressByZipCodeClient.find(code);
        return addressResponseMapper.toAddress(addressResponse);
    }

}

package br.com.learn.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import br.com.learn.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.learn.hexagonal.application.core.domain.Address;

//We utilize Framework here because this pathway is not part of the core.
@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}

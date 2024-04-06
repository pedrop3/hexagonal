package br.com.learn.hexagonal.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.learn.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.learn.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "isValidCpf",ignore = true)
    @Mapping(target = "address",ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

}

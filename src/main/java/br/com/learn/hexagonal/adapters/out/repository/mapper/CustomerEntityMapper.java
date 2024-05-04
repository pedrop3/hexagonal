package br.com.learn.hexagonal.adapters.out.repository.mapper;


import org.mapstruct.Mapper;

import br.com.learn.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.learn.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}

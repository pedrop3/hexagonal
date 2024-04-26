package br.com.learn.hexagonal.adapters.out.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Entity classes are those that will be stored in the database. We should not
 * use domain classes for this purpose. Once again, this is not recommended, as
 * we are using a specific framework.
 */
@Data
@Document(collection = "customers")
public class CustomerEntity {

    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isValidCpf;

}

package br.com.learn.hexagonal.application.ports.out;

import br.com.learn.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String code);
}

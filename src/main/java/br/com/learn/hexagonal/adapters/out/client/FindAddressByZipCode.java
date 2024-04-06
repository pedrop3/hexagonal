package br.com.learn.hexagonal.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.learn.hexagonal.adapters.out.client.response.AddressResponse;

@FeignClient(
    name = "FindAddressByZipCode",
    url = "${api-address.client.address.url}"
)
public interface FindAddressByZipCode {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);
    
} 

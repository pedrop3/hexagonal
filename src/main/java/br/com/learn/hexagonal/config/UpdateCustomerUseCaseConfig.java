package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.learn.hexagonal.adapters.out.UpdateCustomerAdpater;
import br.com.learn.hexagonal.application.core.usercase.FindCustomerByIdUseCase;
import br.com.learn.hexagonal.application.core.usercase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerUseCaseConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdpater updateCustomerAdpater) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdpater);
    }
}

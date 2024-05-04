package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.learn.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.learn.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import br.com.learn.hexagonal.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerUseCaseConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdpater) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdpater);
    }
}

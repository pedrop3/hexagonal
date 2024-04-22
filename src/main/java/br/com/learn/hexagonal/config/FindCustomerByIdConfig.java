package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.learn.hexagonal.application.core.usercase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase insertCustomerUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}

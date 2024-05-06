package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.FindCustomerAllAdapter;
import br.com.learn.hexagonal.application.core.usecase.FindCustomerAllUseCase;

@Configuration
public class FindCustomerAllConfig {

    @Bean
    public FindCustomerAllUseCase findCustomerAllUseCase(FindCustomerAllAdapter findCustomerAllAdapter) {
        return new FindCustomerAllUseCase(findCustomerAllAdapter);
    }

}

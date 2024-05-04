package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.learn.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.learn.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdUserCaseConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUserCase(DeleteCustomerByIdAdapter deleteCustomerByIdAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase) {
        return new DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }
}
